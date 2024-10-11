package com.michel.codingchallenge.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.michel.codingchallenge.R
import com.michel.codingchallenge.model.Item

class ItemViewHolder(
    viewGroup: ViewGroup,
    private val clickCallback: (Item) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
) {

    init {
        itemView.setOnClickListener {
            currentItem?.let {
                clickCallback(it)
            }
        }
    }

    private var currentItem: Item? = null

    fun bind(item: Item) {
        currentItem = item
        itemView.findViewById<TextView>(R.id.title).text = item.title
        itemView.findViewById<TextView>(R.id.description).text = item.description
    }
}
