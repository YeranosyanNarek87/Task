package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.CityData
import com.example.myapplication.mvi.MyIntent
import com.example.myapplication.mvi.FirstState
import com.example.myapplication.repo.MyRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MyRepository
) : ViewModel() {

    val userIntent = Channel<MyIntent>(Channel.BUFFERED)
    private val _state = MutableStateFlow<FirstState>(FirstState.Loading)
    val state: StateFlow<FirstState>
        get() = _state

    val onItemClick: (CityData) -> Unit = {
        userIntent.trySend(MyIntent.Clicked(it))
    }


    fun fetchData() {
        viewModelScope.launch {
            _state.value = FirstState.LoadedData(repository.getMyFavoriteCity())
        }
    }
}
