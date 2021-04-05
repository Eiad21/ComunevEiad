package com.tantawy.eiad.comuneveiad.api

import com.tantawy.eiad.comuneveiad.models.Data
import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("/api/?results=100&inc=name")
    suspend fun getData(): Data
}