package com.example.myapplication.mvi.main

import com.example.myapplication.base.BaseAction
import com.example.myapplication.base.BaseCallable
import com.example.myapplication.domain.MainData

sealed class MainAction : BaseAction {
    data class Init(val data: MainData?) : MainAction()
    object StartLoading : MainAction(), BaseCallable
    object HandleClick : MainAction(), BaseCallable
    object EndLoading : MainAction()
}