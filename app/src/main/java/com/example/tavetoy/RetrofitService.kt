package com.example.tavetoy

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("v1/search/book.json")
    fun getBookData(
        @Header("X-Naver-Client-id")
        clientId: String,
        @Header("X-Naver-Client-Secret")
        clientSecret: String,
        @Query("item")
        query: String,
        @Query("display")
        display: Int? = null,
        @Query("start")
        start: Int? = null
    ): Call<BookRoot>
    fun getBook (

    ): Call<BookRoot>
    fun getBookItem (
        @Path("item")
        title: String
    ): Call<BookData>

}