package com.example.myapplication.base


abstract class BaseReducer<STATE: BaseState, ACTION: BaseAction> {
    abstract fun reduce(state: STATE, action: ACTION): STATE
}