package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.WelcomeData

interface WelcomeScreenDataUseCase {
    suspend fun loadWelcomeData(): WelcomeData?
}