package com.example.myapplication.mvi.welcome

import com.example.myapplication.base.BaseReducer

class WelcomeReducer : BaseReducer<WelcomeState, WelcomeAction>() {
    override fun reduce(state: WelcomeState, action: WelcomeAction): WelcomeState =
        when (action) {
            is WelcomeAction.Init -> {
                state.copy(start = true, showLoading = false, hideLoading = false, welcomeInfo = action.data)
            }
            is WelcomeAction.StartLoading -> {
                state.copy(start = false, showLoading = true, hideLoading = false)
            }
            is WelcomeAction.EndLoading -> {
                state.copy(start = false, showLoading = false, hideLoading = true)
            }
        }
}