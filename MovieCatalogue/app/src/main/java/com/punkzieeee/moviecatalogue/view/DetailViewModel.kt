package com.punkzieeee.moviecatalogue.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.punkzieeee.moviecatalogue.data.MovieEntity
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.data.source.MovieRepository
import com.punkzieeee.moviecatalogue.vo.Resource

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    val movieId = MutableLiveData<String>()
    val showId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    fun setSelectedTVShow(showId: String) {
        this.showId.value = showId
    }

    fun getDetailMovies() : LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getMovies()
    fun getDetailTVShows() : LiveData<Resource<PagedList<TVShowEntity>>> = movieRepository.getTVShows()

    var getDetailMovies: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) {
        id -> movieRepository.getDetailMovies(id)
    }
    var getDetailTVShows: LiveData<Resource<TVShowEntity>> = Transformations.switchMap(showId) {
            id -> movieRepository.getDetailTVShows(id)
    }

    fun setFavoriteMovie() {
        val movieResource = getDetailMovies.value
        if (movieResource != null) {
            val movieDetail = movieResource.data
            if (movieDetail != null) {
                val state = !movieDetail.favorite
                movieRepository.setFavoriteMovies(movieDetail, state)
            }
        }
    }

    fun setFavoriteTVShow() {
        val tvShowResource = getDetailTVShows.value
        if (tvShowResource != null) {
            val tvShowDetail = tvShowResource.data
            if (tvShowDetail != null) {
                val state = !tvShowDetail.favorite
                movieRepository.setFavoriteTVShows(tvShowDetail, state)
            }
        }
    }
}