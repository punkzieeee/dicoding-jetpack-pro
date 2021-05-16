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
import com.punkzieeee.moviecatalogue.databinding.FragmentTvShowFavoriteBinding
import com.punkzieeee.moviecatalogue.utils.ViewModelFactory
import com.punkzieeee.moviecatalogue.view.FavoriteViewModel
import com.punkzieeee.moviecatalogue.vo.Status
import com.punkzieeee.tvshowcatalogue.adapter.FavoriteTVShowAdapter

class TVShowFavoriteFragment : Fragment() {
    private lateinit var fragmentTVShowFavoriteBinding: FragmentTvShowFavoriteBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var favTVShowAdapter: FavoriteTVShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTVShowFavoriteBinding = FragmentTvShowFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentTVShowFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentTVShowFavoriteBinding?.rvTvshow)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
            favTVShowAdapter = FavoriteTVShowAdapter()

            fragmentTVShowFavoriteBinding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavoriteTVShows().observe(this, { tvshow ->
                fragmentTVShowFavoriteBinding?.progressBar?.visibility = View.GONE
                favTVShowAdapter.submitList(tvshow)
            })

            fragmentTVShowFavoriteBinding?.rvTvshow?.layoutManager = LinearLayoutManager(context)
            fragmentTVShowFavoriteBinding?.rvTvshow?.setHasFixedSize(true)
            fragmentTVShowFavoriteBinding?.rvTvshow?.adapter = favTVShowAdapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val courseEntity = favTVShowAdapter.getSwipedData(swipedPosition)
                courseEntity?.let { viewModel.setFavoriteTVShows(it) }
                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    courseEntity?.let { viewModel.setFavoriteTVShows(it) }
                }
                snackbar.show()
            }
        }
    })
}