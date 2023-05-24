package com.example.myapplication.data.repo

import com.example.myapplication.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyRepositoryImpl(
    private val service: ApiService,
    private val localDataProvider: LocalDataProvider
) : MyRepository {
    override suspend fun loadDefault() {
        //TODO("Not yet implemented")
    }

    override suspend fun loadData(): List<Any> = localDataProvider.getFavData()

    override suspend fun getCityWeatherInfo(id: String): Any? =
        withContext(Dispatchers.IO) {
            service.getWeatherInfo(location = id).body()
        }
}
