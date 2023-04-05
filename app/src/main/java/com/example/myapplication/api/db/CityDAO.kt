package com.example.myapplication.api.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CityDAO {
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<City>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: City)
}