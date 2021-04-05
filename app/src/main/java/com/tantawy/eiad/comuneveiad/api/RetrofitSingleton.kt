package com.tantawy.eiad.comuneveiad.api

import com.tantawy.eiad.comuneveiad.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: MyApi by lazy {
        retrofit.create(MyApi::class.java)
    }
}