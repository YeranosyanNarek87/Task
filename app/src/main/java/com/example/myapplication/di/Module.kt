package com.example.myapplication.di

import com.example.myapplication.api.ApiService
import com.example.myapplication.repo.LocalDataProvider
import com.example.myapplication.repo.LocalDataProviderImpl
import com.example.myapplication.repo.MyRepository
import com.example.myapplication.repo.MyRepositoryImpl
import com.example.myapplication.ui.main.MainViewModel
import com.example.myapplication.ui.weather.MyFavoriteCityViewModel
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    val BASE_URL = "https://api.weatherapi.com/v1/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    single<ApiService> { retrofit.create(ApiService::class.java) }
    factory<LocalDataProvider> { LocalDataProviderImpl(gson = Gson()) }

    single<MyRepository> { MyRepositoryImpl(service = get(), localDataProvider = get()) }

    viewModel { MainViewModel(repository = get()) }
    viewModel { MyFavoriteCityViewModel(repository = get()) }
}
