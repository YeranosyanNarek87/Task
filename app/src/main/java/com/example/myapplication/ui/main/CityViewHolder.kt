package com.example.myapplication.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.CityData
import com.example.myapplication.databinding.ItemLayoutBinding

class CityViewHolder(
    private val itemBinding: ItemLayoutBinding,
    private val onItemClicked: ((CityData) -> Unit)
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(city: CityData) {
        itemBinding.run {
            Glide.with(root.context)
                .load(city.avatar)
                .into(image)
            name.text = city.name
        }
        itemView.setOnClickListener { onItemClicked(city) }
    }
}