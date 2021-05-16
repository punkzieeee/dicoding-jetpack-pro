package com.punkzieeee.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.room.Query
import com.punkzieeee.moviecatalogue.data.MovieEntity
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.vo.Resource

interface MovieDataSource {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getTVShows(): LiveData<Resource<PagedList<TVShowEntity>>>
    fun getDetailMovies(id: String): LiveData<Resource<MovieEntity>>
    fun getDetailTVShows(id: String): LiveData<Resource<TVShowEntity>>
    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>
    fun getFavoriteTVShows(): LiveData<PagedList<TVShowEntity>>
    fun setFavoriteMovies(movie: MovieEntity, state: Boolean)
    fun setFavoriteTVShows(show: TVShowEntity, state: Boolean)
}