package com.punkzieeee.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVShowResponse (
        var showId: String,
        var title: String,
        var rating: String,
        var year: Int,
        var season: Int,
        var genre: String,
        var score: Int,
        var tagline: String,
        var overview: String,
        var imagePath: String,
        var favorite: Boolean = false
) : Parcelable