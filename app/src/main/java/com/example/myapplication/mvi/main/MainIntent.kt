package com.example.myapplication.mvi.main

import com.example.myapplication.base.BaseIntent
import com.example.myapplication.domain.ItemData
import com.example.myapplication.domain.MainData

sealed class MainIntent : BaseIntent {
    class Init(val data: MainData?) : MainIntent()
    object StartLoading : MainIntent()
    data class HandleClick(val itemData: ItemData) : MainIntent()
    data class EndLoading(private val data: Any?) : MainIntent()
}