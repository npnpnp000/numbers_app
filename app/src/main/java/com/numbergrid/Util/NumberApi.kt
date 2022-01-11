package com.numbergrid.Util

import com.numbergrid.response.NumbersSearchResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface NumberApi {

    //search for movies by tag
    @GET("raw/8wJzytQX")
     fun searchNumber(
    ): Call<NumbersSearchResponse>

}