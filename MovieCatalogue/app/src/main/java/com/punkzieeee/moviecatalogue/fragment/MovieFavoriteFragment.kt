package com.punkzieeee.moviecatalogue.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.punkzieeee.moviecatalogue.R
import com.punkzieeee.moviecatalogue.adapter.FavoriteMovieAdapter
import com.punkzieeee.moviecatalogue.databinding.FragmentMovieFavoriteBinding
import com.punkzieeee.moviecatalogue.utils.ViewModelFactory
import com.punkzieeee.moviecatalogue.view.FavoriteViewModel
import com.punkzieeee.moviecatalogue.vo.Status

class MovieFavoriteFragment : Fragment() {
    private lateinit var fragmentMovieFavoriteBinding: FragmentMovieFavoriteBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var favMovieAdapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieFavoriteBinding = FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentMovieFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentMovieFavoriteBinding?.rvFavMovie)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
            favMovieAdapter = FavoriteMovieAdapter()

            fragmentMovieFavoriteBinding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavoriteMovies().observe(this, { movies ->
                fragmentMovieFavoriteBinding?.progressBar?.visibility = View.GONE
                favMovieAdapter.submitList(movies)
            })

            fragmentMovieFavoriteBinding?.rvFavMovie?.layoutManager = LinearLayoutManager(context)
            fragmentMovieFavoriteBinding?.rvFavMovie?.setHasFixedSize(true)
            fragmentMovieFavoriteBinding?.rvFavMovie?.adapter = favMovieAdapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val courseEntity = favMovieAdapter.getSwipedData(swipedPosition)
                courseEntity?.let { viewModel.setFavoriteMovies(it) }
                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    courseEntity?.let { viewModel.setFavoriteMovies(it) }
                }
                snackbar.show()
            }
        }
    })
}