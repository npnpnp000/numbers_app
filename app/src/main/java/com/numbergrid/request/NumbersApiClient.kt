package com.numbergrid.request

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.numbergrid.model.NumberModel
import com.numbergrid.response.NumbersSearchResponse
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class NumbersApiClient (var liveNumbers: MutableLiveData<ArrayList<NumberModel?>> = MutableLiveData()) {
    companion object {
        val instances = NumbersApiClient()
    }

    var jobToTagSearch: Job? = null

    fun searchNumber() {
        val movieApi = Servicey.instances.numberApi
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
        var responseCall: Call<NumbersSearchResponse>? = null
        jobToTagSearch = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
//           withContext(Dispatchers.IO + exceptionHandler,{
//                val responseCall: Call<MoviesSearchResponse> = movieApi
            responseCall = movieApi
                .searchNumber()
        }
        jobToTagSearch!!.invokeOnCompletion {
            Log.e("jobToTagSearch", responseCall!!.request().url().url().toString())
            responseCall?.enqueue(object : Callback<NumbersSearchResponse> {
                override fun onResponse(
                    call: Call<NumbersSearchResponse>,
                    response: Response<NumbersSearchResponse>
                ) {
                    if (response.code() == 200) {
                        val numbers = response.body()!!.getNumbers()
                        instances.liveNumbers.postValue(numbers)

                        instances.liveNumbers.value?.forEach {
                            Log.e("test", "name: ${it?.number}")
                        }
                    } else {
                        try {
                            Log.e("jobToTagSearch", "Exception")
                        } catch (e: IOException) {
                            e.stackTrace
                        }
                    }

                }

                override fun onFailure(call: Call<NumbersSearchResponse>, t: Throwable) {
                    Log.e("onFailure", t.stackTraceToString())
                }

            })
        }
    }
}

