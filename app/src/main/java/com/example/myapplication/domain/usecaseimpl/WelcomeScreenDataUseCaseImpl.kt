package com.example.myapplication.domain.usecaseimpl

import com.example.myapplication.domain.WelcomeData
import com.example.myapplication.domain.usecases.WelcomeScreenDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WelcomeScreenDataUseCaseImpl() : WelcomeScreenDataUseCase {
    override suspend fun loadWelcomeData(): WelcomeData? = withContext(Dispatchers.IO) {
        null
    }
}