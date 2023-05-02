package com.example.tavetoy

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

data class BookRoot(
    @SerializedName("query")
    @Expose
    val query: String,

    @SerializedName("lastBuildDate")
    @Expose
    val lastBuildDate: String,

    @SerializedName("display")
    @Expose
    val display: Int,

    @SerializedName("start")
    @Expose
    val start: Int,

    @SerializedName("sort")
    @Expose
    val sort: String,

    @SerializedName("items")
    @Expose
    val items: List<BookData>
)
