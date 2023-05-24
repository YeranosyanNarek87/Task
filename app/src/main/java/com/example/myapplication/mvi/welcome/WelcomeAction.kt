package com.example.myapplication.mvi.welcome

import com.example.myapplication.base.BaseAction
import com.example.myapplication.base.BaseCallable
import com.example.myapplication.domain.WelcomeData

sealed class WelcomeAction : BaseAction {
    data class Init(val data: WelcomeData?) : WelcomeAction()
    object StartLoading : WelcomeAction(), BaseCallable
    object EndLoading : WelcomeAction()
}