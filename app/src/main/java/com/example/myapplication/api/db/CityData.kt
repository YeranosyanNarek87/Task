package com.example.myapplication.api.db

import androidx.room.PrimaryKey

data class CityData(
    @PrimaryKey val id: String,
    val name: String,
    val avatar: String,
)

