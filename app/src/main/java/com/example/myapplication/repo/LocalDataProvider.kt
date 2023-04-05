package com.example.myapplication.repo

import com.example.myapplication.data.CityData
import com.example.myapplication.data.CityWeatherInfo

interface LocalDataProvider {
    suspend fun saveData(data: CityWeatherInfo)
    suspend fun getFavData():List<CityData>
    suspend fun getData(): CityWeatherInfo?
}