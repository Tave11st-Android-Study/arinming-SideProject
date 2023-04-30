package com.example.tavetoy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("v1/search/blog?query={item}")
    fun getBook (
        @Path("item")
        book: String
    ): Call<BookRoot>

}