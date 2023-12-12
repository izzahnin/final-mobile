package com.d121211103.book.data.source.remote

import com.d121211103.book.data.response.GetBooksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    
    @GET("books")
    suspend fun getBooks(
        @Query("languages") language: String = "en",
        @Query("topic") topic: String = "children",
    ): GetBooksResponse
}