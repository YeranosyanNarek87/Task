package com.example.myapplication.api.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CityDAO {
    @Query("SELECT * FROM cityWeatherData")
    suspend fun getAllCities(): List<CityWeatherData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city: CityWeatherData)

    @Query("SELECT * FROM c")
    suspend fun getDefCities(): List<CityData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDefCity(city: CityData)
}