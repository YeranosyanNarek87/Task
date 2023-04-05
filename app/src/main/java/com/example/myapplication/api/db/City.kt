package com.example.myapplication.api.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City(
    @PrimaryKey val id: Int,
    val name: String,
    val email: String
)