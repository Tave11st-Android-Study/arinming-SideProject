package com.example.tavetoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tavetoy.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {

    // 뷰바인딩
    private lateinit var binding: ActivityMainBinding


    // 레트로핏 서비스 선언
    private val retrofitService by lazy { retrofitBuilder() }

    // 레트로핏 빌더 선언, baseUrl 명시
    private fun retrofitBuilder(): Retrofit = Retrofit.Builder()
        .baseUrl("https://openapi.naver.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val bookService: RetrofitService =
        retrofitService.create(RetrofitService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 뷰 바인딩
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




        // 클라이언트 아이디, 패스워드
        val CLIENT_ID = "GBRvp2C0B4A0iYQjFL6z"
        val CLIENT_SECRET = "F0TaAoZUIT"


        binding.btnSearch.setOnClickListener {
            if (binding.edtBook.text != null) {
                // API 불러오기
                bookService
                    .getBookData(CLIENT_ID, CLIENT_SECRET, binding.edtBook.text.toString())
                    .enqueue(object: Callback<BookRoot> {
                        override fun onResponse(call: Call<BookRoot>, response: Response<BookRoot>) {
                            // 성공적으로 불러옴 : 코드 200
                            if (response.isSuccessful) {
                                Toast.makeText(this@MainActivity, "성공", Toast.LENGTH_SHORT).show()
                                binding.tvTitle.text = response.body().toString()
                                binding.tvDisplay.text = response.body().toString()
                            }
                        }

                        // 불러오기 실패
                        override fun onFailure(call: Call<BookRoot>, t: Throwable) {
                            Log.d("로그", t.message.toString())
                        }
                    })
            }

        }

    }

}




