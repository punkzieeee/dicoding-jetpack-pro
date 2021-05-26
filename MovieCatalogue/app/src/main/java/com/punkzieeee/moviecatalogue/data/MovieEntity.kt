package com.punkzieeee.moviecatalogue.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "movieId")
        var movieId: String,
        @ColumnInfo(name = "title")
        var title: String,
        @ColumnInfo(name = "rating")
        var rating: String,
        @ColumnInfo(name = "dateReleased")
        var dateReleased: String,
        @ColumnInfo(name = "genre")
        var genre: String,
        @ColumnInfo(name = "score")
        var score: Int,
        @ColumnInfo(name = "tagline")
        var tagline: String,
        @ColumnInfo(name = "overview")
        var overview: String,
        @ColumnInfo(name = "imagePath")
        var imagePath: String,
        @ColumnInfo(name = "favorite")
        var favorite: Boolean = false
)
