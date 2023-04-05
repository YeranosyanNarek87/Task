package com.example.myapplication.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.CityData
import com.example.myapplication.databinding.ItemLayoutBinding

class MyAdapter(
    private val onItemClicked: ((CityData) -> Unit)
) : ListAdapter<CityData, CityViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CityViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context)), onItemClicked)

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) =
        holder.bind(getItem(position))

    private companion object {
        val diffCallback = object :
            DiffUtil.ItemCallback<CityData>() {
            override fun areItemsTheSame(
                oldItem: CityData,
                newItem: CityData
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: CityData,
                newItem: CityData
            ): Boolean = oldItem.name == newItem.name
                    && oldItem.avatar == newItem.avatar
        }
    }
}