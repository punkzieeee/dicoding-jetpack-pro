package com.punkzieeee.moviecatalogue.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.punkzieeee.moviecatalogue.data.MovieEntity
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.data.source.MovieRepository

class FavoriteViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = movieRepository.getFavoriteMovies()
    fun getFavoriteTVShows(): LiveData<PagedList<TVShowEntity>> = movieRepository.getFavoriteTVShows()

    fun setFavoriteMovies(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorite
        movieRepository.setFavoriteMovies(movieEntity, newState)
    }

    fun setFavoriteTVShows(tvShowEntity: TVShowEntity) {
        val newState = !tvShowEntity.favorite
        movieRepository.setFavoriteTVShows(tvShowEntity, newState)
    }
}