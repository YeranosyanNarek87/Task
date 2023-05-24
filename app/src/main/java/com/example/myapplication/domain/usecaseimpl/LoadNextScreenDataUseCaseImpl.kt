package com.example.myapplication.domain.usecaseimpl

import com.example.myapplication.data.repo.MyRepository
import com.example.myapplication.domain.usecases.LoadNextScreenDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoadNextScreenDataUseCaseImpl(private val repository: MyRepository) : LoadNextScreenDataUseCase {
    override suspend fun loadData() = withContext(Dispatchers.IO) {
        repository.loadData()
    }
}