package com.punkzieeee.moviecatalogue.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.data.source.MovieRepository
import com.punkzieeee.moviecatalogue.utils.DataDummy
import com.punkzieeee.moviecatalogue.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TVShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TVShowEntity>

    @Before
    fun setUp() {
        viewModel = TVShowViewModel(tvShowRepository)
    }

    @Test
    fun getTVShows() {
        val dummyTVShow = Resource.success(pagedList)
        `when`(dummyTVShow.data?.size).thenReturn(10)
        val tvshow = MutableLiveData<Resource<PagedList<TVShowEntity>>>()
        tvshow.value = dummyTVShow

        `when`(tvShowRepository.getTVShows()).thenReturn(tvshow)
        val tvShowEntities = viewModel.getTVShows().value?.data
        verify<MovieRepository>(tvShowRepository).getTVShows()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getTVShows().observeForever(observer)
        verify(observer).onChanged(dummyTVShow)
    }
}