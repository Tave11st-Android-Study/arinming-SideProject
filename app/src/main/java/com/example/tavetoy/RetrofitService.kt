package com.example.tavetoy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("search.api/item/{book}")
    fun getBook (
        @Path("book")
        book: String
    ): Call<BookRoot>

}