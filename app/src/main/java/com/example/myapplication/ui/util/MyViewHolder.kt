package com.example.myapplication.ui.util

import com.example.myapplication.databinding.ItemLayoutBinding
import com.example.myapplication.domain.ItemData

class MyViewHolder(
    private val itemBinding: ItemLayoutBinding,
    onItemClicked: ((ItemData) -> Unit)
) : BaseViewHolder<ItemData>(itemBinding.root, onItemClicked) {

    override fun bind(itemData: ItemData) {
        itemBinding.run {
            /**
            Bind data
             */
        }
        super.bind(itemData)
    }
}