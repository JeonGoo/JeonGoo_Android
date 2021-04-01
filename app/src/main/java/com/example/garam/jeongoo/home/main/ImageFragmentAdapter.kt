package com.example.garam.jeongoo.home.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.garam.jeongoo.R

class ImageFragmentAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ImageFragment(R.drawable.ic_home_black_24dp)
            1 -> ImageFragment(R.drawable.ic_launcher_background)
            else -> ImageFragment(R.drawable.ic_launcher_foreground)
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}