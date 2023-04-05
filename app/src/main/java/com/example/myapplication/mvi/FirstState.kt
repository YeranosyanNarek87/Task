package com.example.myapplication.mvi

import com.example.myapplication.data.CityData

sealed class FirstState {

    object Loading : FirstState()
    data class LoadedData(val data: List<CityData>) : FirstState()
    data class Error(val error: String?) : FirstState()
}

