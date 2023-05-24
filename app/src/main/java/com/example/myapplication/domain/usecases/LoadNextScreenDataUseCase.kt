package com.example.myapplication.domain.usecases

interface LoadNextScreenDataUseCase {
    suspend fun loadData(): Any?
}