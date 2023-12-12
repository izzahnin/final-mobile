package com.d121211103.book.data.repository

import com.d121211103.book.data.response.GetBooksResponse
import com.d121211103.book.data.source.remote.ApiService

class BooksRepository(private val apiService: ApiService) {

    suspend fun getBooks(): GetBooksResponse {
        return apiService.getBooks()
    }
}