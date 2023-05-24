package com.example.myapplication.mvi.main

import com.example.myapplication.base.BaseState
import com.example.myapplication.domain.MainData

data class MainState(
    val start: Boolean = false,
    val showLoading: Boolean = false,
    val hideLoading: Boolean = false,
    val mainInfo: MainData? = null,
) : BaseState
