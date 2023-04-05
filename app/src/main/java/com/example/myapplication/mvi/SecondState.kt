package com.example.myapplication.mvi

import com.example.myapplication.data.CityWeatherData

sealed class SecondState {
    object Loading : SecondState()
    data class LoadedData(val data: CityWeatherData) : SecondState()
    data class Error(val error: String?) : SecondState()
}
