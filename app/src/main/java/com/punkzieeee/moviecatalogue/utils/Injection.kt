package com.punkzieeee.moviecatalogue.utils

import android.content.Context
import com.punkzieeee.moviecatalogue.data.source.MovieDataSource
import com.punkzieeee.moviecatalogue.data.source.MovieRepository
import com.punkzieeee.moviecatalogue.data.source.local.LocalDataSource
import com.punkzieeee.moviecatalogue.data.source.local.room.MovieDatabase
import com.punkzieeee.moviecatalogue.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): MovieRepository {
        val database = MovieDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()
        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}