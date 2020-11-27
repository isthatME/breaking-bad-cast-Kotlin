package com.example.shakil.kotlinjsonexample.Common

import com.example.shakil.kotlinjsonexample.Interface.RetrofitService
import com.example.shakil.kotlinjsonexample.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://breakingbadapi.com/api/"

    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}