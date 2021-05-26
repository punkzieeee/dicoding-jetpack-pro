package com.punkzieeee.moviecatalogue.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.punkzieeee.moviecatalogue.data.MovieEntity
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.data.source.MovieRepository
import com.punkzieeee.moviecatalogue.utils.DataDummy
import com.punkzieeee.moviecatalogue.vo.Resource
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val dummyTVShow = DataDummy.generateDummyTVShow()[0]
    private val movieId = dummyMovie.movieId
    private val showId = dummyTVShow.showId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TVShowEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TVShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(repository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTVShow(showId)
    }

    @Test
    fun getDetailMovies() {
        val expected = MutableLiveData<Resource<MovieEntity>>()
        expected.value = Resource.success(dummyMovie)

        `when`(repository.getDetailMovies(movieId)).thenReturn(expected)
        viewModel.getDetailMovies.observeForever(movieObserver)
        verify(movieObserver).onChanged(expected.value)

        assertEquals(expected.value?.data?.title, viewModel.getDetailMovies.value?.data?.title)
        assertEquals(expected.value?.data?.rating, viewModel.getDetailMovies.value?.data?.rating)
        assertEquals(expected.value?.data?.tagline, viewModel.getDetailMovies.value?.data?.tagline)
        assertEquals(expected.value?.data?.dateReleased, viewModel.getDetailMovies.value?.data?.dateReleased)
        assertEquals(expected.value?.data?.imagePath, viewModel.getDetailMovies.value?.data?.imagePath)
    }

    @Test
    fun getDetailTVShows() {
        val expected = MutableLiveData<Resource<TVShowEntity>>()
        expected.value = Resource.success(dummyTVShow)

        `when`(repository.getDetailTVShows(showId)).thenReturn(expected)
        viewModel.getDetailTVShows.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(expected.value)

        assertEquals(expected.value?.data?.title, viewModel.getDetailTVShows.value?.data?.title)
        assertEquals(expected.value?.data?.rating, viewModel.getDetailTVShows.value?.data?.rating)
        assertEquals(expected.value?.data?.tagline, viewModel.getDetailTVShows.value?.data?.tagline)
        assertEquals(expected.value?.data?.year, viewModel.getDetailTVShows.value?.data?.year)
        assertEquals(expected.value?.data?.season, viewModel.getDetailTVShows.value?.data?.season)
        assertEquals(expected.value?.data?.imagePath, viewModel.getDetailTVShows.value?.data?.imagePath)
    }

    @Test
    fun setFavMovie() {
        val expected = MutableLiveData<Resource<MovieEntity>>()
        expected.value = Resource.success(dummyMovie)

        `when`(repository.getDetailMovies(movieId)).thenReturn(expected)
        viewModel.setFavoriteMovie()
        viewModel.getDetailMovies.observeForever(movieObserver)

        verify(movieObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDetailMovies.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun setFavTVShow() {
        val expected = MutableLiveData<Resource<TVShowEntity>>()
        expected.value = Resource.success(dummyTVShow)

        `when`(repository.getDetailTVShows(showId)).thenReturn(expected)
        viewModel.setFavoriteTVShow()
        viewModel.getDetailTVShows.observeForever(tvShowObserver)

        verify(tvShowObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDetailTVShows.value

        assertEquals(expectedValue, actualValue)
    }
}