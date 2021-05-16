package com.punkzieeee.moviecatalogue.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.punkzieeee.moviecatalogue.adapter.FavoriteSectionsPagerAdapter
import com.punkzieeee.moviecatalogue.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)
        setActionBarTitle("Favorite")

        val favoriteSectionsPagerAdapter = FavoriteSectionsPagerAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPager.adapter = favoriteSectionsPagerAdapter
        activityFavoriteBinding.tabs.setupWithViewPager(activityFavoriteBinding.viewPager)
        supportActionBar?.elevation = 0f
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}