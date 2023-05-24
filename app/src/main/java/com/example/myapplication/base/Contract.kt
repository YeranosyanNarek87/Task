package com.example.myapplication.base

import kotlinx.coroutines.flow.Flow

interface BaseAction
interface BaseIntent
interface BaseState
interface BaseCallable

interface MviModel<STATE : BaseState, INTENT : BaseIntent> {
    val state: Flow<STATE>
    fun dispatchIntent(intent: INTENT)
}

interface ViewRenderer<STATE : BaseState> {
    fun render(state: STATE)
}
