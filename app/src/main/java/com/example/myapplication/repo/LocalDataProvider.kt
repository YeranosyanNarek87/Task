package com.example.myapplication.repo

import com.example.myapplication.data.CityWeatherInfo

interface LocalDataProvider {
    suspend fun saveData(data: CityWeatherInfo)
    suspend fun getData(): CityWeatherInfo?
}