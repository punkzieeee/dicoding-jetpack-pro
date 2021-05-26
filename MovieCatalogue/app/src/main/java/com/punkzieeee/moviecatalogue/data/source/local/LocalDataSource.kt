package com.punkzieeee.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.punkzieeee.moviecatalogue.data.MovieEntity
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val mMovieDao: MovieDao){
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies()

    fun getTVShows(): DataSource.Factory<Int, TVShowEntity> = mMovieDao.getTVShows()

    fun getDetailMovies(id: String): LiveData<MovieEntity> = mMovieDao.getDetailMovies(id)

    fun getDetailTVShows(id: String): LiveData<TVShowEntity> = mMovieDao.getDetailTVShows(id)

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoriteMovies()

    fun getFavoriteTVShows(): DataSource.Factory<Int, TVShowEntity> = mMovieDao.getFavoriteTVShows()

    fun insertMovies(movies: List<MovieEntity>) {
        mMovieDao.insertMovies(movies)
    }

    fun insertTVShows(tvShows: List<TVShowEntity>) {
        mMovieDao.insertTVShows(tvShows)
    }

    fun insertDetailMovie(movies: List<MovieEntity>) {
        mMovieDao.insertDetailMovie(movies)
    }

    fun insertDetailTVShow(tvShows: List<TVShowEntity>) {
        mMovieDao.insertDetailTVShow(tvShows)
    }

    fun setFavoriteMovies(movie: MovieEntity, state: Boolean) {
        movie.favorite = state
        mMovieDao.updateMovie(movie)
    }

    fun setFavoriteTVShows(show: TVShowEntity, state: Boolean) {
        show.favorite = state
        mMovieDao.updateTVShow(show)
    }

}