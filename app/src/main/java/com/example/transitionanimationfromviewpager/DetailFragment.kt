package com.example.transitionanimationfromviewpager

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.transitionanimationfromviewpager.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private var position: Int = 0
    private var page: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(EXTRA_POSITION)
            page = it.getInt(EXTRA_PAGE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.image.transitionName = "${getString(R.string.transition_image)}_${page}_$position"
        binding.text.transitionName = "${getString(R.string.transition_text)}_${page}_$position"
        binding.text.text = "test_${page}_$position"
        return binding.root
    }

    companion object {

        private const val EXTRA_POSITION = "com.example.transitionanimationfromviewpager#POSITION"
        private const val EXTRA_PAGE = "com.example.transitionanimationfromviewpager#PAGE"


        fun newInstance(position: Int, page: Int): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_POSITION, position)
                    putInt(EXTRA_PAGE, page)
                }
            }
        }
    }

}