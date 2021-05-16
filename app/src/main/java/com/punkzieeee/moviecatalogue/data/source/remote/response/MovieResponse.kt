package com.punkzieeee.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
        var movieId: String,
        var title: String,
        var rating: String,
        var dateReleased: String,
        var genre: String,
        var score: Int,
        var tagline: String,
        var overview: String,
        var imagePath: String,
        var favorite: Boolean = false
) : Parcelable
