package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.MainData

interface MainScreenDataUseCase {
    suspend fun loadMainData(): MainData?
}