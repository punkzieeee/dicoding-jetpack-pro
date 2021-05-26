package com.punkzieeee.tvshowcatalogue.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.punkzieeee.moviecatalogue.R
import com.punkzieeee.moviecatalogue.data.TVShowEntity
import com.punkzieeee.moviecatalogue.databinding.ItemsTvShowBinding
import com.punkzieeee.moviecatalogue.detail.TVShowDetailActivity


class TVShowAdapter : PagedListAdapter<TVShowEntity, TVShowAdapter.TVShowViewHolder>(DIFF_CALLBACK) {
    private var listTVShow = ArrayList<TVShowEntity>()

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TVShowEntity>() {
            override fun areItemsTheSame(oldItem: TVShowEntity, newItem: TVShowEntity): Boolean {
                return oldItem.showId == newItem.showId
            }
            override fun areContentsTheSame(oldItem: TVShowEntity, newItem: TVShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun setTVShows(tvshow: List<TVShowEntity>?) {
        if (tvshow == null) return
        this.listTVShow.clear()
        this.listTVShow.addAll(tvshow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val itemsTVShowsBinding = ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(itemsTVShowsBinding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null) {
            holder.bind(tvshow)
        }
    }

    class TVShowViewHolder(private val binding: ItemsTvShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: TVShowEntity) {
            with(binding) {
                tvItemTitle.text = tvshow.title
                tvItemTagline.text = tvshow.tagline
                tvItemTagline.visibility = if (tvshow.tagline == "") View.GONE else View.VISIBLE
                tvItemRating.text = tvshow.rating
                tvItemScore.text = "${tvshow.score}%"
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, TVShowDetailActivity::class.java)
                    intent.putExtra(TVShowDetailActivity.EXTRA_SHOW, tvshow.showId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(tvshow.imagePath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }
}