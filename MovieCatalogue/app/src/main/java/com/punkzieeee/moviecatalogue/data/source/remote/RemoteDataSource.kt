package com.punkzieeee.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.punkzieeee.moviecatalogue.data.source.remote.response.MovieResponse
import com.punkzieeee.moviecatalogue.data.source.remote.response.TVShowResponse
import com.punkzieeee.moviecatalogue.utils.EspressoIdlingResource
import com.punkzieeee.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(helper).apply { instance = this }
                }
    }

    fun getMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({ result.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILLIS)
        return result
    }

    fun getTVShows(): LiveData<ApiResponse<List<TVShowResponse>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<TVShowResponse>>>()
        handler.postDelayed({ result.value = ApiResponse.success(jsonHelper.loadTVShows())
            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILLIS)
        return result
    }

    fun getDetailMovies(id: String): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({ result.value = ApiResponse.success(jsonHelper.loadDetailMovies(id))
            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILLIS)
        return result
    }

    fun getDetailTVShows(id: String): LiveData<ApiResponse<List<TVShowResponse>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<TVShowResponse>>>()
        handler.postDelayed({ result.value = ApiResponse.success(jsonHelper.loadDetailTVShows(id))
            EspressoIdlingResource.decrement()}, SERVICE_LATENCY_IN_MILLIS)
        return result
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(courseResponses: List<MovieResponse>)
    }

    interface LoadTVShowsCallback {
        fun onAllTVShowsReceived(courseResponses: List<TVShowResponse>)
    }
}