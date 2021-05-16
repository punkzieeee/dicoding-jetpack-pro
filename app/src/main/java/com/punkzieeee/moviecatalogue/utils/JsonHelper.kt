package com.punkzieeee.moviecatalogue.utils

import android.content.Context
import com.punkzieeee.moviecatalogue.data.source.remote.response.MovieResponse
import com.punkzieeee.moviecatalogue.data.source.remote.response.TVShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private var genreList: String = ""
    private var genreArray = ArrayList<String>()

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("Movie.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)
                val movieId = movie.getString("id")
                val title = movie.getString("title")
                val rating = movie.getString("certification")
                val dateReleased = movie.getString("release_date")
                val genreJsonArray = movie.getJSONArray("genres")
                for (j in 0 until genreJsonArray.length()) {
                    if (j == genreJsonArray.length()-1) {
                        genreList += "${genreJsonArray.getJSONObject(j).getString("name")}"
                        genreArray.add(genreList)
                        genreList = ""
                    }
                    else
                        genreList += "${genreJsonArray.getJSONObject(j).getString("name")}, "
                }
                val genre = genreArray[i]
                val score = (movie.getDouble("vote_average")*10).toInt()
                val tagline = movie.getString("tagline")
                val overview = movie.getString("overview")
                val imagePath = movie.getString("poster_path")

                val movieResponse = MovieResponse(movieId, title, rating, dateReleased, genre, score, tagline, overview, imagePath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTVShows(): List<TVShowResponse> {
        val list = ArrayList<TVShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TVShow.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)
                val showId = tvshow.getString("id")
                val title = tvshow.getString("name")
                val rating = tvshow.getString("certification")
                val year = (tvshow.getString("first_air_date").substring(0,4)).toInt()
                val season = tvshow.getInt("number_of_seasons")
                val genreJsonArray = tvshow.getJSONArray("genres")
                for (j in 0 until genreJsonArray.length()) {
                    if (j == genreJsonArray.length()-1) {
                        genreList += "${genreJsonArray.getJSONObject(j).getString("name")}"
                        genreArray.add(genreList)
                        genreList = ""
                    }
                    else
                        genreList += "${genreJsonArray.getJSONObject(j).getString("name")}, "
                }
                val genre = genreArray[i]
                val score = (tvshow.getDouble("vote_average")*10).toInt()
                val tagline = tvshow.getString("tagline")
                val overview = tvshow.getString("overview")
                val imagePath = tvshow.getString("poster_path")

                val tvShowResponse = TVShowResponse(showId, title, rating, year, season, genre, score, tagline, overview, imagePath)
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailMovies(id: String): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("Movie.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)
                val movieId = movie.getString("id")
                val title = movie.getString("title")
                val rating = movie.getString("certification")
                val dateReleased = movie.getString("release_date")
                val genreJsonArray = movie.getJSONArray("genres")
                for (j in 0 until genreJsonArray.length()) {
                    if (j == genreJsonArray.length()-1) {
                        genreList += "${genreJsonArray.getJSONObject(j).getString("name")}"
                        genreArray.add(genreList)
                        genreList = ""
                    }
                    else
                        genreList += "${genreJsonArray.getJSONObject(j).getString("name")}, "
                }
                val genre = genreArray[i]
                val score = (movie.getDouble("vote_average")*10).toInt()
                val tagline = movie.getString("tagline")
                val overview = movie.getString("overview")
                val imagePath = movie.getString("poster_path")
                if (movieId == id) {
                    val movieResponse = MovieResponse(movieId, title, rating, dateReleased, genre, score, tagline, overview, imagePath)
                    list.add(movieResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailTVShows(id: String): List<TVShowResponse> {
        val list = ArrayList<TVShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TVShow.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)
                val showId = tvshow.getString("id")
                val title = tvshow.getString("name")
                val rating = tvshow.getString("certification")
                val year = (tvshow.getString("first_air_date").substring(0,4)).toInt()
                val season = tvshow.getInt("number_of_seasons")
                val genreJsonArray = tvshow.getJSONArray("genres")
                for (j in 0 until genreJsonArray.length()) {
                    if (j == genreJsonArray.length()-1) {
                        genreList += "${genreJsonArray.getJSONObject(j).getString("name")}"
                        genreArray.add(genreList)
                        genreList = ""
                    }
                    else
                        genreList += "${genreJsonArray.getJSONObject(j).getString("name")}, "
                }
                val genre = genreArray[i]
                val score = (tvshow.getDouble("vote_average")*10).toInt()
                val tagline = tvshow.getString("tagline")
                val overview = tvshow.getString("overview")
                val imagePath = tvshow.getString("poster_path")
                if (showId == id) {
                    val tvShowResponse = TVShowResponse(showId, title, rating, year, season, genre, score, tagline, overview, imagePath)
                    list.add(tvShowResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}