package com.example.tavetoy

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookData(
    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("link")
    @Expose
    val link: String,

    @SerializedName("image")
    @Expose
    val image: String,


    @SerializedName("author")
    @Expose
    val author: String,

    @SerializedName("discount")
    @Expose
    val discount: String,

    @SerializedName("publisher")
    @Expose
    val publisher: String,


    @SerializedName("pubdate")
    @Expose
    val pubdate: String,

    @SerializedName("isbn")
    @Expose
    val isbn: String,

    @SerializedName("description")
    @Expose
    val description: String,

)
