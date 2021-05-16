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
import com.punkzieeee.moviecatalogue.databinding.ActivityMovieDetailBinding
import com.punkzieeee.moviecatalogue.databinding.ContentMovieDetailBinding
import com.punkzieeee.moviecatalogue.utils.JsonHelper
import com.punkzieeee.moviecatalogue.utils.ViewModelFactory
import com.punkzieeee.moviecatalogue.view.DetailViewModel
import com.punkzieeee.moviecatalogue.vo.Status

class TVShowDetailActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentMovieDetailBinding
    private lateinit var tvShowSelected: String

    companion object {
        const val EXTRA_SHOW = "extra_show"
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
            val tvshowId = extras.getString(EXTRA_SHOW)
            if (tvshowId != null) {
                viewModel.setSelectedTVShow(tvshowId)
                viewModel.getDetailTVShows.observe(this, { getDetailTVShowsResource ->
                    if (getDetailTVShowsResource != null) {
                        when (getDetailTVShowsResource.status) {
                            Status.LOADING -> detailContentBinding.progressBar.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> {
                                detailContentBinding.progressBar.visibility = View.GONE
                                for (show in JsonHelper(this).loadTVShows()) {
                                    if (show.showId == tvshowId) {
                                        detailContentBinding.movieTitle.text = show.title
                                        detailContentBinding.movieDate.text = show.year.toString()
                                        detailContentBinding.movieDescription.text = show.overview
                                        detailContentBinding.movieTagline.text = show.tagline
                                        detailContentBinding.movieTagline.visibility =
                                            if (show.tagline == "") View.GONE else View.VISIBLE
                                        detailContentBinding.movieGenre.text = show.genre
                                        detailContentBinding.movieRating.text = show.rating
                                        detailContentBinding.movieScore.text = show.score.toString()
                                        detailContentBinding.tvSeason.visibility = View.VISIBLE
                                        detailContentBinding.tvSeason.text = "${show.season} | "
                                        detailContentBinding.tvShow.visibility = View.VISIBLE

                                        Glide.with(this)
                                            .load(show.imagePath)
                                            .transform(RoundedCorners(20))
                                            .apply(
                                                RequestOptions.placeholderOf(R.drawable.ic_loading)
                                                    .error(R.drawable.ic_error)
                                            )
                                            .into(detailContentBinding.imagePoster)

                                        tvShowSelected = show.showId
                                    }
                                }
                            }
                            Status.ERROR -> {
                                detailContentBinding.progressBar.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }

        detailContentBinding.favorite.setOnClickListener{
            viewModel.setSelectedMovie(tvShowSelected)
            viewModel.getDetailTVShows.observe(this, { show ->
                if (show != null) {
                    when (show.status) {
                        Status.LOADING -> detailContentBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            detailContentBinding.progressBar.visibility = View.GONE
                            viewModel.setFavoriteTVShow()
                            val state = show.data!!.favorite
                            setFavoriteTVShow(state)
                        }
                        Status.ERROR -> {
                            detailContentBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Gagal mengupdate favorite", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }

        detailContentBinding.share.setOnClickListener{
            Toast.makeText(this, "I recommend everyone to watch ${detailContentBinding.movieTitle.text} ;)", Toast.LENGTH_LONG).show()
        }
    }

    private fun setFavoriteTVShow(state: Boolean) {
        if (state) {
            detailContentBinding.favorite.setImageResource(R.drawable.ic_fav_on)
        } else {
            detailContentBinding.favorite.setImageResource(R.drawable.ic_fav_off)
        }
    }
}