package com.tantawy.eiad.comuneveiad.repository

import com.tantawy.eiad.comuneveiad.api.RetrofitSingleton
import com.tantawy.eiad.comuneveiad.models.Data
import retrofit2.Call

class Repository {

    suspend fun getData(): Data {
        return RetrofitSingleton.api.getData()
    }
}