package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class CityWeatherInfo(
    @SerializedName("location")
    val location: LocationInfo,
    @SerializedName("current")
    val current: Current
)