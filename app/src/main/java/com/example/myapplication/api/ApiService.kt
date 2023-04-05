package com.example.myapplication.api

import com.example.myapplication.data.CityWeatherInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("current.jsonc")
   suspend fun getWeatherInfo(
        @Query("key") apiKey: String? = "aaad4aee7c374cb1966185323230304",
        @Query("q") location: String?,
    ): Response<CityWeatherInfo>
}