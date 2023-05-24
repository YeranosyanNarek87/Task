package com.example.myapplication.mvi.welcome

import com.example.myapplication.base.BaseState
import com.example.myapplication.domain.WelcomeData

data class WelcomeState(
    val start: Boolean = false,
    val showLoading: Boolean = false,
    val hideLoading: Boolean = false,
    val welcomeInfo: WelcomeData? = null,
) : BaseState