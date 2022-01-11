package com.numbergrid.request

import com.numbergrid.Util.NumberApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Servicey {
    companion object {
        val instances = Servicey()
    }
//    ​ ​https://pastebin.com/raw/8wJzytQX​
    private val retrofitBuilder =
        Retrofit.Builder().baseUrl("https://pastebin.com").addConverterFactory(GsonConverterFactory.create())
    private val retrofit = retrofitBuilder.build()
    val numberApi = retrofit.create(NumberApi::class.java)
}