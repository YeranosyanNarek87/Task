package com.example.myapplication.repo

import com.example.myapplication.data.CityData
import com.example.myapplication.data.CityWeatherInfo

interface MyRepository {
    suspend fun getMyFavoriteCity(): List<CityData>
    suspend fun getCityWeatherInfo(id: String): CityWeatherInfo?
}