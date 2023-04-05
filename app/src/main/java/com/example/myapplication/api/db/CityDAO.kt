package com.example.myapplication.api.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface CityDAO {
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<City>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: City)
}