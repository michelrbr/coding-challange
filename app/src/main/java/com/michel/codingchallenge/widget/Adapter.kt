package com.michel.codingchallenge.widget

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.michel.codingchallenge.model.Item

class Adapter(
    private val items: List<Item>,
    private val selectCallback: (Item) -> Unit
): RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(parent, selectCallback)

    override fun getItemCount(): Int = items.lastIndex

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items.get(position))
    }
}
