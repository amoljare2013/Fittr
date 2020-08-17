package com.ankit.jare.model.api

import com.amol.jare.fittrapp.model.fittrResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET


interface ApiService {
    @GET("sample.json")
    fun getList(): Call<fittrResponse>

//     fun getList():Call<List<fittrResponse>>
//    fun getList(cb: Callback<List<fittrResponse?>?>?)
//    fun contacts(cb: Callback<List<User?>?>?)
}