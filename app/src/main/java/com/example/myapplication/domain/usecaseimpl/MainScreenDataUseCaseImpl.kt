package com.example.myapplication.domain.usecaseimpl

import com.example.myapplication.domain.MainData
import com.example.myapplication.domain.usecases.MainScreenDataUseCase

class MainScreenDataUseCaseImpl : MainScreenDataUseCase {
    override suspend fun loadMainData(): MainData? = null
}