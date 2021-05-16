package com.punkzieeee.moviecatalogue.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.data.source.MovieRepository
import com.punkzieeee.moviecatalogue.vo.Resource

class TVShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTVShows() : LiveData<Resource<PagedList<TVShowEntity>>> = movieRepository.getTVShows()
}