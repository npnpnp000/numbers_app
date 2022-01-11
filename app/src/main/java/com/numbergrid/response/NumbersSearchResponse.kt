package com.numbergrid.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.numbergrid.model.NumberModel

// this class getting movies by the filter
class NumbersSearchResponse {

    @SerializedName("numbers")
    @Expose()
    private var numbers = arrayListOf<NumberModel?>()


    fun getNumbers(): ArrayList<NumberModel?>{
        return numbers
    }

    override fun toString(): String {
        return "NumberSearchResponse(numbers=$numbers)"
    }


}