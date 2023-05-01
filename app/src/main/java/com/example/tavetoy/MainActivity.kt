package com.example.tavetoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.tavetoy.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val retrofitService by lazy { retrofitBuilder() }

    private fun retrofitBuilder(): Retrofit = Retrofit.Builder()
        .baseUrl("https://openapi.naver.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bookService: RetrofitService =
            retrofitService.create(RetrofitService::class.java)

        val CLIENT_ID = "GBRvp2C0B4A0iYQjFL6z"
        val CLIENT_SECRET = "F0TaAoZUIT"
        val callGetSearchBookData = bookService.getBookData(CLIENT_ID, CLIENT_SECRET, "테스트")
/*
        callGetSearchBookData
            .enqueue(object : Callback<BookRoot>{
            override fun onResponse(call: Call<BookRoot>, response: Response<BookRoot>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "성공", Toast.LENGTH_SHORT).show()
                    binding.textView.text = response.body()?.book?.title.toString()
                }
            }

            override fun onFailure(call: Call<BookRoot>, t: Throwable) {
                Log.d("로그", t.message.toString())
            }
        })
        */
        bookService
            .getBookData(CLIENT_ID, CLIENT_SECRET, "비행운")
            .enqueue(object: Callback<BookRoot> {
                override fun onResponse(call: Call<BookRoot>, response: Response<BookRoot>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@MainActivity, "성공", Toast.LENGTH_SHORT).show()
                        binding.textView.text = response.body()?.book?.title.toString()
                    }
                }

                override fun onFailure(call: Call<BookRoot>, t: Throwable) {
                    Log.d("로그", t.message.toString())
                }
            })
    }

}




