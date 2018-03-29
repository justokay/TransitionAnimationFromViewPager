package com.example.transitionanimationfromviewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TransitionPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return TransitionPageFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return 2
    }
}