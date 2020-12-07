package com.kotlinjsonexample.Common

import com.kotlinjsonexample.Interface.RetrofitService
import com.kotlinjsonexample.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://breakingbadapi.com/api/"

    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(
        BASE_URL
    ).create(RetrofitService::class.java)
}