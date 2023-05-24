package com.example.myapplication.mvi.welcome

import com.example.myapplication.base.BaseIntent
import com.example.myapplication.domain.WelcomeData

sealed class WelcomeIntent : BaseIntent {
    class Init(val data: WelcomeData?) : WelcomeIntent()
    object StartLoading : WelcomeIntent()
    data class EndLoading(private val data: Any?) : WelcomeIntent()
}