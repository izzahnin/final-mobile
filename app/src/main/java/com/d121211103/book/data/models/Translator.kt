package com.d121211103.book.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Translator(
    val birth_year: Int,
    val death_year: Int,
    val name: String
): Parcelable