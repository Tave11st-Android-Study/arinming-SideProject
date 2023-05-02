package com.example.tavetoy

data class BookRoot(
    val query: String,
    val display: Int,
    val start: Int,
    val sort: String,
    val item: BookData
)
