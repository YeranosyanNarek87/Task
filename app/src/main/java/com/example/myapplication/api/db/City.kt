package com.example.myapplication.api.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City(
    @PrimaryKey val id: String,
    val name: String,
    val avatar: String,
    val country: String,
    val region: String,
    val tempC: String,
    val tempF: String,
)