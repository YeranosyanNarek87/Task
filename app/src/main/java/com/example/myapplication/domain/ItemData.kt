package com.example.myapplication.domain

data class ItemData(
    val id: String = "",
    val name: String? = null,
    val component_1: Any? = null,
    val component_2: Any? = null,
    val component_3: Any? = null
) : BaseItemData
