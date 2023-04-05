package com.example.myapplication.mvi

import com.example.myapplication.data.CityData

sealed class MyIntent {
    data class Clicked(val data: CityData): MyIntent()
}
