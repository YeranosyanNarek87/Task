package com.example.myapplication.ui.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.myapplication.databinding.ItemLayoutBinding
import com.example.myapplication.domain.ItemData

class MyAdapter(
    private val onItemClicked: ((ItemData) -> Unit)
) : ListAdapter<ItemData, MyViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context)), onItemClicked)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(getItem(position))

    private companion object {
        val diffCallback = object :
            DiffUtil.ItemCallback<ItemData>() {
            override fun areItemsTheSame(
                oldItem: ItemData,
                newItem: ItemData
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ItemData,
                newItem: ItemData
            ): Boolean = oldItem.name == newItem.name
        }
    }
}