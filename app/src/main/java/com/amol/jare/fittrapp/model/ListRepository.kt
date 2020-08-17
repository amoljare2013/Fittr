package com.amol.jare.fittrapp.model

import com.ankit.jare.model.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.NullPointerException

class ListRepository {

    fun getRepoList(onResult: (isSuccess: Boolean, response: fittrResponse?) -> Unit) {
        try {
            ApiClient.instance.getList().enqueue(object : Callback<fittrResponse> {
                override fun onResponse(
                    call: Call<fittrResponse>?,response: Response<fittrResponse>?) {
                    if (response != null && response.isSuccessful) {
                        onResult(true, response.body()!!)
                    } else {
                        onResult(false, null)
                    }

                }

                override fun onFailure(call: Call<fittrResponse>?, t: Throwable?) {
                    onResult(false, null)
                }

            })
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

    companion object {
        private var INSTANCE: ListRepository? = null
        fun getInstance() = INSTANCE
            ?: ListRepository().also {
                INSTANCE = it
            }
    }
}