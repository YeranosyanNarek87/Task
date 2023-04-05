package com.example.myapplication.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityData(
    val id: String = "yerevan",
    val name: String = "Yerevan",
    val avatar: String = "",
): Parcelable
