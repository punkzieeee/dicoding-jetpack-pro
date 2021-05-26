package com.punkzieeee.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import com.punkzieeee.moviecatalogue.data.MovieEntity
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.data.source.local.LocalDataSource
import com.punkzieeee.moviecatalogue.data.source.remote.RemoteDataSource
import com.punkzieeee.moviecatalogue.utils.AppExecutors
import com.punkzieeee.moviecatalogue.utils.DataDummy
import com.punkzieeee.moviecatalogue.utils.LiveDataTestUtil
import com.punkzieeee.moviecatalogue.utils.PagedListUtil
import com.punkzieeee.moviecatalogue.view.MovieViewModel
import com.punkzieeee.moviecatalogue.view.TVShowViewModel
import com.punkzieeee.moviecatalogue.vo.Resource
import junit.framework.Assert.assertNotNull
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val fakeMovieRepository = FakeMovieRepository(remote, local, appExecutors)
    private val movieResponse = DataDummy.generateRemoteDummyMovie()
    private val tvShowResponse = DataDummy.generateRemoteDummyTVShow()

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var tvViewModel: TVShowViewModel

    @Test
    fun getMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        fakeMovieRepository.getMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getTVShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(local.getTVShows()).thenReturn(dataSourceFactory)
        fakeMovieRepository.getTVShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTVShow()))
        verify(local).getTVShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getFavMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        fakeMovieRepository.getFavoriteMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getFavoriteMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavTVShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(local.getFavoriteTVShows()).thenReturn(dataSourceFactory)
        fakeMovieRepository.getFavoriteTVShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTVShow()))
        verify(local).getFavoriteTVShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }
}