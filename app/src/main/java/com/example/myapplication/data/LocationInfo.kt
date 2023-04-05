package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class LocationInfo(
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("country")
    val country: String
)
