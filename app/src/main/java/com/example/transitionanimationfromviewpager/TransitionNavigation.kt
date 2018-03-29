package com.example.transitionanimationfromviewpager

import android.view.View

interface TransitionNavigation {

    fun goToDetail(transitionItems: List<View>, position: Int, page: Int)

}