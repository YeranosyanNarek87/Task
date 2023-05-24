package com.example.myapplication.mvi.weather

sealed class SecondState {
    object Loading : SecondState()
    data class LoadedData(val data: Any) : SecondState()
    data class Error(val error: String?) : SecondState()
}
