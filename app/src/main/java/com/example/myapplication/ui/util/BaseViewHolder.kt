package com.example.myapplication.ui.util

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.domain.BaseItemData

abstract class BaseViewHolder<BID: BaseItemData>(
    view: View,
    private val onItemClicked: ((BID) -> Unit)
) : RecyclerView.ViewHolder(view) {

    open fun bind(itemData: BID) {
        itemView.setOnClickListener { onItemClicked.invoke(itemData) }
    }
}