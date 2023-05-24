package com.example.myapplication.data.repo

interface LocalDataProvider {
    suspend fun saveData(data: Any)
    suspend fun getFavData():List<Any>
    suspend fun getData(): Any?
}