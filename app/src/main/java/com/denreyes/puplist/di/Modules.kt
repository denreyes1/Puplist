package com.denreyes.puplist.di

import com.denreyes.puplist.DogsViewModel
import com.denreyes.puplist.data.DogsAPI
import com.denreyes.puplist.data.DogsRepository
import com.denreyes.puplist.data.DogsRepositoryImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.dsl.module
import retrofit2.Retrofit

val appModules = module {
    single<DogsRepository> { DogsRepositoryImpl(get(), get()) }
    single { Dispatchers.IO }
    single { DogsViewModel(get()) }
    single {
        val contentType = "application/json".toMediaType()
        Retrofit.Builder()
            .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory(contentType)) // Kotlinx serialization converter
            .baseUrl("https://api.thedogapi.com/v1/")
            .build()
    }
    single { get<Retrofit>().create(DogsAPI::class.java) }
}