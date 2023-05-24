package com.example.myapplication.di

import com.example.myapplication.api.ApiService
import com.example.myapplication.api.db.AppDatabase
import com.example.myapplication.data.repo.LocalDataProvider
import com.example.myapplication.data.repo.LocalDataProviderImpl
import com.example.myapplication.data.repo.MyRepository
import com.example.myapplication.data.repo.MyRepositoryImpl
import com.example.myapplication.domain.usecaseimpl.LoadNextScreenDataUseCaseImpl
import com.example.myapplication.domain.usecaseimpl.MainScreenDataUseCaseImpl
import com.example.myapplication.domain.usecaseimpl.WelcomeScreenDataUseCaseImpl
import com.example.myapplication.domain.usecases.LoadNextScreenDataUseCase
import com.example.myapplication.domain.usecases.MainScreenDataUseCase
import com.example.myapplication.domain.usecases.WelcomeScreenDataUseCase
import com.example.myapplication.ui.main.MainViewModel
import com.example.myapplication.ui.welcome.WelcomeViewModel
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

    single { get<AppDatabase>().myDao() }
    //single<AppDatabase> { get<getInstance()>() }

    single<ApiService> { retrofit.create(ApiService::class.java) }
    factory<LocalDataProvider> { LocalDataProviderImpl(gson = Gson()) }

    single<MyRepository> { MyRepositoryImpl(service = get(), localDataProvider = get()) }
    single<MainScreenDataUseCase> { MainScreenDataUseCaseImpl() }
    single<WelcomeScreenDataUseCase> { WelcomeScreenDataUseCaseImpl() }
    single<LoadNextScreenDataUseCase> { LoadNextScreenDataUseCaseImpl(repository = get()) }

    viewModel { MainViewModel(mainScreenData = get()) }
    viewModel {
        WelcomeViewModel(
            welcomeScreenData = get(),
            nextScreenData = get()
        )
    }
}
