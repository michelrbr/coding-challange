package com.michel.codingchallenge.widget

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.michel.codingchallenge.model.Item

/*
In a more complex project the items wouldn't be provided in the constructor I would rather create
a method to set the items, having it internally as an AsyncListDiffer to improve performance when the items
update.
 */
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
