package com.example.myapplication.ui.welcome

import androidx.lifecycle.viewModelScope
import com.example.myapplication.base.BaseReducer
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.domain.usecases.LoadNextScreenDataUseCase
import com.example.myapplication.domain.usecases.WelcomeScreenDataUseCase
import com.example.myapplication.mvi.welcome.WelcomeAction
import com.example.myapplication.mvi.welcome.WelcomeIntent
import com.example.myapplication.mvi.welcome.WelcomeReducer
import com.example.myapplication.mvi.welcome.WelcomeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WelcomeViewModel(
    private val welcomeScreenData: WelcomeScreenDataUseCase,
    private val nextScreenData: LoadNextScreenDataUseCase
) :
    BaseViewModel<WelcomeIntent, WelcomeAction, WelcomeState, BaseReducer<WelcomeState, WelcomeAction>>(
        WelcomeState()
    ) {

    override val reducer = WelcomeReducer()

    init {
        viewModelScope.launch {
            dispatchIntent(WelcomeIntent.Init(data = welcomeScreenData.loadWelcomeData()))
        }
    }

    override fun call(action: WelcomeAction) {
        when (action) {
            is WelcomeAction.StartLoading -> {
                viewModelScope.launch(Dispatchers.Main) {
                    dispatchIntent(WelcomeIntent.EndLoading(nextScreenData.loadData()))
                }
            }
            else -> return
        }
    }

    override fun handleIntent(intent: WelcomeIntent): WelcomeAction =
        when (intent) {
            is WelcomeIntent.Init -> WelcomeAction.Init(data = intent.data)
            is WelcomeIntent.StartLoading -> WelcomeAction.StartLoading
            is WelcomeIntent.EndLoading -> WelcomeAction.EndLoading
        }
}