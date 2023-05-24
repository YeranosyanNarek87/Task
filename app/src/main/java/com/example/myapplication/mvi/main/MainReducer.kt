package com.example.myapplication.mvi.main

import com.example.myapplication.base.BaseReducer

class MainReducer : BaseReducer<MainState, MainAction>() {
    override fun reduce(state: MainState, action: MainAction): MainState =
        when (action) {
            is MainAction.Init -> {
                state.copy(start = true, showLoading = false, hideLoading = false, mainInfo = action.data)
            }
            is MainAction.StartLoading -> {
                state.copy(start = false, showLoading = true, hideLoading = false)
            }
            is MainAction.EndLoading -> {
                state.copy(start = false, showLoading = false, hideLoading = true)
            }
            is MainAction.HandleClick -> {
                /**
                Here need to change state regarding item click
                 */
                state
            }
        }
}