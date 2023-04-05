package com.example.myapplication.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.CityData
import com.example.myapplication.data.CityWeatherData
import com.example.myapplication.mvi.SecondState
import com.example.myapplication.repo.MyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyFavoriteCityViewModel(private val repository: MyRepository) : ViewModel() {

    private val _state = MutableStateFlow<SecondState>(SecondState.Loading)
    val state: StateFlow<SecondState>
        get() = _state

    fun fetchData(data: CityData) {
        viewModelScope.launch {
            val result = repository.getCityWeatherInfo(data.id)
            if (result == null) {
                _state.value = SecondState.Error("Error")
            } else {
                _state.value = SecondState.LoadedData(
                    CityWeatherData(
                        name = data.name,
                        id = data.id,
                        avatar = data.avatar,
                        country = result.location.country,
                        region = result.location.region,
                        tempC = result.current.tempC,
                        tempF = result.current.tempF,
                    )
                )
            }
        }
    }
}
