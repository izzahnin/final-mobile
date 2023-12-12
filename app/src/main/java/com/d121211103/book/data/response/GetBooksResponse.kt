package com.d121211103.book.data.response

import com.d121211103.book.data.models.Book
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class GetBooksResponse(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("previous")
    val previous: Int?,
    @SerialName("results")
    val results: List<Book>
)