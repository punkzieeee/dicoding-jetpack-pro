package com.punkzieeee.moviecatalogue.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.punkzieeee.moviecatalogue.data.MovieEntity
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.data.source.MovieRepository
import com.punkzieeee.moviecatalogue.utils.DataDummy
import com.punkzieeee.moviecatalogue.vo.Resource
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieRepository

    @Mock
    private lateinit var favMovieObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var favTVShowObserver: Observer<PagedList<TVShowEntity>>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(repository)
    }

    @Test
    fun getFavoriteMovies() {
        val expected = MutableLiveData<PagedList<MovieEntity>>()
        expected.value = PagedMovieTestDataSources.snapshot(DataDummy.generateDummyMovie())

        `when`(repository.getFavoriteMovies()).thenReturn(expected)
        viewModel.getFavoriteMovies().observeForever(favMovieObserver)
        verify(favMovieObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getFavoriteMovies().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun getFavoriteTVShows() {
        val expected = MutableLiveData<PagedList<TVShowEntity>>()
        expected.value = PagedShowTestDataSources.snapshot(DataDummy.generateDummyTVShow())

        `when`(repository.getFavoriteTVShows()).thenReturn(expected)
        viewModel.getFavoriteTVShows().observeForever(favTVShowObserver)
        verify(favTVShowObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getFavoriteTVShows().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    class PagedMovieTestDataSources private constructor(private val items: List<MovieEntity>) : PositionalDataSource<MovieEntity>() {
        companion object {
            fun snapshot(items: List<MovieEntity> = listOf()): PagedList<MovieEntity> {
                return PagedList.Builder(PagedMovieTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<MovieEntity>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<MovieEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }

    class PagedShowTestDataSources private constructor(private val items: List<TVShowEntity>) : PositionalDataSource<TVShowEntity>() {
        companion object {
            fun snapshot(items: List<TVShowEntity> = listOf()): PagedList<TVShowEntity> {
                return PagedList.Builder(PagedShowTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<TVShowEntity>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<TVShowEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}