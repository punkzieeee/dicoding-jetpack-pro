package com.punkzieeee.moviecatalogue.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.punkzieeee.moviecatalogue.R
import com.punkzieeee.moviecatalogue.adapter.MovieAdapter
import com.punkzieeee.moviecatalogue.databinding.ActivityMovieDetailBinding
import com.punkzieeee.moviecatalogue.databinding.ContentMovieDetailBinding
import com.punkzieeee.moviecatalogue.utils.JsonHelper
import com.punkzieeee.moviecatalogue.utils.ViewModelFactory
import com.punkzieeee.moviecatalogue.view.DetailViewModel
import com.punkzieeee.moviecatalogue.vo.Status

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentMovieDetailBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMovieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityMovieDetailBinding.detailContent

        setContentView(activityMovieDetailBinding.root)
        setSupportActionBar(activityMovieDetailBinding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                viewModel.getDetailMovies.observe(this, { getDetailMoviesResource ->
                    if (getDetailMoviesResource != null) {
                        when (getDetailMoviesResource.status) {
                            Status.LOADING -> detailContentBinding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> {
                                detailContentBinding.progressBar.visibility = View.GONE
                                for (movie in JsonHelper(this).loadMovies()) {
                                    if (movie.movieId == movieId) {
                                        detailContentBinding.movieTitle.text = movie.title
                                        detailContentBinding.movieDate.text = movie.dateReleased
                                        detailContentBinding.movieDescription.text = movie.overview
                                        detailContentBinding.movieTagline.text = movie.tagline
                                        detailContentBinding.movieTagline.visibility =
                                            if (movie.tagline == "") View.GONE else View.VISIBLE
                                        detailContentBinding.movieGenre.text = movie.genre
                                        detailContentBinding.movieRating.text = movie.rating
                                        detailContentBinding.movieScore.text = movie.score.toString()

                                        Glide.with(this)
                                            .load(movie.imagePath)
                                            .transform(RoundedCorners(20))
                                            .apply(
                                                RequestOptions.placeholderOf(R.drawable.ic_loading)
                                                    .error(R.drawable.ic_error)
                                            )
                                            .into(detailContentBinding.imagePoster)

                                        val state = getDetailMoviesResource.data!!.favorite
                                        setFavoriteMovie(state)
                                    }
                                }
                            }
                            Status.ERROR -> {
                                detailContentBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }

        detailContentBinding.favorite.setOnClickListener{
            viewModel.setFavoriteMovie()
        }

        detailContentBinding.share.setOnClickListener{
            Toast.makeText(this, "I recommend everyone to watch ${detailContentBinding.movieTitle.text} ;)", Toast.LENGTH_LONG).show()
        }
    }

    private fun setFavoriteMovie(state: Boolean) {
        if (state) {
            detailContentBinding.favorite.setImageResource(R.drawable.ic_fav_on)
        } else {
            detailContentBinding.favorite.setImageResource(R.drawable.ic_fav_off)
        }
    }
}