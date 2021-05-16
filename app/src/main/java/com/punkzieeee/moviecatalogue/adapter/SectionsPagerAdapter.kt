package com.punkzieeee.moviecatalogue.adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.punkzieeee.moviecatalogue.R
import com.punkzieeee.moviecatalogue.fragment.MovieFragment
import com.punkzieeee.moviecatalogue.fragment.TVShowFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tvshow)
    }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> MovieFragment()
                1 -> TVShowFragment()
                else -> Fragment()
            }
}