package com.d121211103.book.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Book(
    val authors: List<Author?>,
    val bookshelves: List<String?>,
    val copyright: Boolean?,
    val download_count: Int?,
    val formats: Formats?,
    val id: Int?,
    val languages: List<String?>,
    val media_type: String?,
    val subjects: List<String?>,
    val title: String?,
    val translators: List<Translator?>
): Parcelable