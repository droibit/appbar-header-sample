package com.github.droibit.appbar_header.sample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.droibit.appbar_header.sample.TextListAdapter.ViewHolder

class TextListAdapter(context: Context) : RecyclerView.Adapter<ViewHolder>() {

  private val inflater: LayoutInflater = LayoutInflater.from(context)

  private val texts = mutableListOf<String>()

  override fun getItemCount(): Int = texts.size

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ViewHolder {
    return ViewHolder(
        itemView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
    )
  }

  override fun onBindViewHolder(
    holder: ViewHolder,
    position: Int
  ) {
    holder.bind(texts[position])
  }

  fun replace(newTexts: List<String>) {
    texts.clear()
    texts.addAll(newTexts)
    notifyDataSetChanged()
  }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textView = itemView.findViewById<TextView>(android.R.id.text1)

    fun bind(text: String) {
      textView.text = text
    }
  }
}