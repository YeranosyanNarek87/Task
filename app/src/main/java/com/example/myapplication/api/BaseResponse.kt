package com.example.myapplication.api

data class ApiResponse<T>(
    val status: Boolean,
    val data: T?,
    val message: String?
)

sealed class NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : ApiResult<T>
    data class Error(val code: Int, val message: String?) : ApiResult<Nothing>
    data class Exception(val e: Throwable) : ApiResult<Nothing>
}

sealed interface ApiResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : ApiResult<T>
    data class Error(val code: Int, val message: String?) : ApiResult<Nothing>
    data class Exception(val e: Throwable) : ApiResult<Nothing>
}