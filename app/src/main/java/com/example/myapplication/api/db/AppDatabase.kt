package com.example.myapplication.api.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [City::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): CityDAO
}