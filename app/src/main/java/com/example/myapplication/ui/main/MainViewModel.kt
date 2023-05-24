package com.example.myapplication.ui.main

import androidx.lifecycle.viewModelScope
import com.example.myapplication.base.BaseReducer
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.domain.usecases.MainScreenDataUseCase
import com.example.myapplication.mvi.main.MainAction
import com.example.myapplication.mvi.main.MainIntent
import com.example.myapplication.mvi.main.MainReducer
import com.example.myapplication.mvi.main.MainState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainScreenData: MainScreenDataUseCase
) : BaseViewModel<MainIntent, MainAction, MainState, BaseReducer<MainState, MainAction>>(
    MainState()
) {

    override val reducer = MainReducer()

    init {
        viewModelScope.launch {
            dispatchIntent(MainIntent.Init(data = mainScreenData.loadMainData()))
        }
    }

    override fun call(action: MainAction) {
        when (action) {
            is MainAction.StartLoading -> {
                viewModelScope.launch(Dispatchers.Main) {
                    dispatchIntent(MainIntent.EndLoading(mainScreenData.loadMainData()))
                }
            }
            else -> return
        }
    }

    override fun handleIntent(intent: MainIntent): MainAction =
        when (intent) {
            is MainIntent.Init -> MainAction.Init(data = intent.data)
            is MainIntent.StartLoading -> MainAction.StartLoading
            is MainIntent.EndLoading -> MainAction.EndLoading
            is MainIntent.HandleClick -> MainAction.HandleClick
        }
}
