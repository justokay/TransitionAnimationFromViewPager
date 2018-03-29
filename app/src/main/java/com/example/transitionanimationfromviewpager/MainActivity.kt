package com.example.transitionanimationfromviewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.ChangeClipBounds
import android.transition.ChangeTransform
import android.transition.TransitionSet
import android.view.View

class MainActivity : AppCompatActivity(), TransitionNavigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.root, MainFragment())
                .commitAllowingStateLoss()

    }

    override fun goToDetail(transitionItems: List<View>, position: Int, page: Int) {
        val transaction = supportFragmentManager.beginTransaction()

        transitionItems.forEach {
            transaction.addSharedElement(it, it.transitionName)
        }

        val detailFragment = DetailFragment.newInstance(position, page)
        val transitionSet = TransitionSet().apply {
            addTransition(ChangeTransform())
            addTransition(ChangeClipBounds())
            addTransition(ChangeBounds())
        }
        detailFragment.sharedElementEnterTransition = transitionSet
        detailFragment.sharedElementReturnTransition = transitionSet

        transaction.replace(R.id.root, detailFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
