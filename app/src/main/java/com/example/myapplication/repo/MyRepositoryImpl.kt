package com.example.myapplication.repo

import com.example.myapplication.api.ApiService
import com.example.myapplication.data.CityData
import com.example.myapplication.data.CityWeatherInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyRepositoryImpl(
    private val service: ApiService,
    private val localDataProvider: LocalDataProvider
) : MyRepository {
    override suspend fun getMyFavoriteCity(): List<CityData> = localDataProvider.getFavData()

    override suspend fun getCityWeatherInfo(id: String): CityWeatherInfo? =
        withContext(Dispatchers.IO) {
            service.getWeatherInfo(location = id).body()
        }
}
