package com.punkzieeee.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.punkzieeee.moviecatalogue.data.MovieEntity
import com.punkzieeee.moviecatalogue.data.NetworkBoundResource
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.data.source.local.LocalDataSource
import com.punkzieeee.moviecatalogue.data.source.remote.ApiResponse
import com.punkzieeee.moviecatalogue.data.source.remote.RemoteDataSource
import com.punkzieeee.moviecatalogue.data.source.remote.response.MovieResponse
import com.punkzieeee.moviecatalogue.data.source.remote.response.TVShowResponse
import com.punkzieeee.moviecatalogue.utils.AppExecutors
import com.punkzieeee.moviecatalogue.vo.Resource

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource,
                          private val localDataSource: LocalDataSource,
                          private val appExecutors: AppExecutors
) : MovieDataSource {

    override fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object: NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>> (appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean = data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> = remoteDataSource.getMovies()

            public override fun saveCallResult(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (i in movieResponse.indices) {
                    val response = movieResponse[i]
                    val movie = MovieEntity(response.movieId, response.title, response.rating, response.dateReleased, response.genre,
                        response.score, response.tagline, response.overview, response.imagePath, false)

                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getTVShows(): LiveData<Resource<PagedList<TVShowEntity>>> {
        return object: NetworkBoundResource<PagedList<TVShowEntity>, List<TVShowResponse>> (appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TVShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTVShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TVShowEntity>?): Boolean = data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TVShowResponse>>> = remoteDataSource.getTVShows()

            public override fun saveCallResult(tvShowResponse: List<TVShowResponse>) {
                val tvshowList = ArrayList<TVShowEntity>()
                for (i in tvShowResponse.indices) {
                    val response = tvShowResponse[i]
                    val tvShow = TVShowEntity(response.showId, response.title, response.rating, response.year, response.season,
                        response.genre, response.score, response.tagline, response.overview, response.imagePath)

                    tvshowList.add(tvShow)
                }
                localDataSource.insertTVShows(tvshowList)
            }

        }.asLiveData()
    }

    override fun getDetailMovies(id: String): LiveData<Resource<MovieEntity>> {
        return object: NetworkBoundResource<MovieEntity, List<MovieResponse>> (appExecutors) {
            public override fun loadFromDB(): LiveData<MovieEntity> = localDataSource.getDetailMovies(id)

            override fun shouldFetch(data: MovieEntity?): Boolean = data?.movieId == null || data.movieId.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> = remoteDataSource.getDetailMovies(id)

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(response.movieId, response.title, response.rating, response.dateReleased, response.genre,
                        response.score, response.tagline, response.overview, response.imagePath, false)
                    movieList.add(movie)
                }
                localDataSource.insertDetailMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailTVShows(id: String): LiveData<Resource<TVShowEntity>> {
        return object: NetworkBoundResource<TVShowEntity, List<TVShowResponse>> (appExecutors) {
            public override fun loadFromDB(): LiveData<TVShowEntity> = localDataSource.getDetailTVShows(id)

            override fun shouldFetch(data: TVShowEntity?): Boolean = data?.showId == null || data.showId.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TVShowResponse>>> = remoteDataSource.getDetailTVShows(id)

            public override fun saveCallResult(data: List<TVShowResponse>) {
                val tvshowList = ArrayList<TVShowEntity>()
                for (response in data) {
                    val tvShow = TVShowEntity(response.showId, response.title, response.rating, response.year, response.season,
                        response.genre, response.score, response.tagline, response.overview, response.imagePath, false)
                    tvshowList.add(tvShow)
                }
                localDataSource.insertDetailTVShow(tvshowList)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteTVShows(): LiveData<PagedList<TVShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTVShows(), config).build()
    }

    override fun setFavoriteMovies(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute{ localDataSource.setFavoriteMovies(movie, state) }
    }

    override fun setFavoriteTVShows(show: TVShowEntity, state: Boolean) {
        appExecutors.diskIO().execute{ localDataSource.setFavoriteTVShows(show, state) }
    }
}