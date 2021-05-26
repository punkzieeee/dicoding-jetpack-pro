package com.punkzieeee.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.punkzieeee.moviecatalogue.data.MovieEntity
import com.punkzieeee.moviecatalogue.data.TVShowEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieentities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentities")
    fun getTVShows(): DataSource.Factory<Int, TVShowEntity>

    @Query("SELECT * FROM movieentities WHERE movieId = :id")
    fun getDetailMovies(id: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tvshowentities WHERE showId = :id")
    fun getDetailTVShows(id: String): LiveData<TVShowEntity>

    @Query("SELECT * FROM movieentities WHERE favorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentities WHERE favorite = 1")
    fun getFavoriteTVShows(): DataSource.Factory<Int, TVShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTVShows(tvShows: List<TVShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailMovie(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailTVShow(tvShows: List<TVShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTVShow(tvShow: TVShowEntity)
}