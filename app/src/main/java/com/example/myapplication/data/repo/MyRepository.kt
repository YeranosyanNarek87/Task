package com.example.myapplication.data.repo

interface MyRepository {

    suspend fun loadDefault()
    suspend fun loadData(): Any?
    suspend fun getCityWeatherInfo(id: String): Any?
}