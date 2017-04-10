package com.github.marlonlom.brono

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.itemImage
import kotlinx.android.synthetic.main.item_row.view.itemTitle

class ItemAdapter(val items: List<Item>,
    val itemClickListener: (Item) -> Unit) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bindItem(items[position])
  }

  override fun getItemCount(): Int {
    return items.size
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
      parent.inflate(R.layout.item_row), itemClickListener)

  class ViewHolder(view: View, val itemClickListener: (Item) -> Unit) : RecyclerView.ViewHolder(
      view) {
    fun bindItem(item: Item) {
      with(item) {
        itemView.itemTitle.text = item.title
        Picasso.with(itemView.context).load(item.url).into(itemView.itemImage)
        itemView.setOnClickListener { itemClickListener(item) }
      }
    }
  }
}