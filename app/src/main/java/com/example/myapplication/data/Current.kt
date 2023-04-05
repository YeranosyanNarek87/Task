package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("temp_c")
    val tempC: String,
    @SerializedName("temp_f")
    val tempF: String
)
