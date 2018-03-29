package com.example.transitionanimationfromviewpager

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.transitionanimationfromviewpager.databinding.ListItemBinding
import java.lang.ref.WeakReference

class TransitionListAdapter(
        navigation: TransitionNavigation,
        val page: Int
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val navigationRef = WeakReference(navigation)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ViewHolder
        val context = holder.itemView.context

        holder.binding.text.transitionName = "${context.getString(R.string.transition_text)}_${page}_$position"
        holder.binding.image.transitionName = "${context.getString(R.string.transition_image)}_${page}_$position"
        holder.binding.text.text = "test_${page}_$position"

    }

    private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding: ListItemBinding = DataBindingUtil.bind(itemView)

        init {
            binding.root.setOnClickListener {
                navigationRef.get()?.goToDetail(
                        listOf(
                                binding.image,
                                binding.text
                        ),
                        layoutPosition,
                        page
                )
            }
        }
    }

}