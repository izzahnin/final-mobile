package com.d121211103.book.data

import com.d121211103.book.data.repository.BooksRepository
import com.d121211103.book.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val booksRepository: BooksRepository
}

class DefaultAppContainer: AppContainer {
    private val BASE_URL = "https://gutendex.com"

    val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val booksRepository: BooksRepository
        get() = BooksRepository(retrofitService)
}