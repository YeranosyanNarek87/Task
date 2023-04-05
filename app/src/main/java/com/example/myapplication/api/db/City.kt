package com.example.myapplication.api.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class City(
    @PrimaryKey val id: Int,
    val name: String,
    val email: String
)