package com.ankit.jare.model.api

import com.amol.jare.fittrapp.model.fittrResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("sample.json")
    fun getList(): Call<fittrResponse>
}