package com.d121211103.book.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Formats(
    @SerialName("application/epub+zip")
    val application_epub_zip: String?,
    @SerialName("application/octet-stream")
    val application_octet_stream: String?,
    @SerialName("application/rdf+xml")
    val application_rdf_xml: String?,
    @SerialName("application/x-mobipocket-ebook")
    val application_x_mobipocket_ebook: String?,
    @SerialName("image/jpeg")
    val image_jpeg: String?,
    @SerialName("text/html")
    val text_html: String?,
    @SerialName("text/plain; charset=us-ascii")
    val text_plain_charset_us_ascii: String?,
): Parcelable

//    val application/epub+zip: String,
//    val application/octet-stream: String,
//    val application/pdf: String,
//    val application/prs.tex: String,
//    val application/rdf+xml: String,
//    val application/x-mobipocket-ebook: String,
//    val image/jpeg: String,
//    val text/html: String,
//    val text/html; charset=iso-8859-1: String,
//    val text/html; charset=utf-8: String,
//    val text/plain; charset=iso-8859-1: String,
//    val text/plain; charset=us-ascii: String,
//    val text/plain; charset=utf-8: String