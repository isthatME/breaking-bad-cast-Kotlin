package com.kotlinjsonexample.Interface

import com.kotlinjsonexample.Model.Character
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("characters")
    fun getMovieList(): Call<MutableList<Character>>
}