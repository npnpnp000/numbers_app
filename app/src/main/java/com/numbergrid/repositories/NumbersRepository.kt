package com.numbergrid.repositories

import androidx.lifecycle.LiveData
import com.numbergrid.model.NumberModel
import com.numbergrid.request.NumbersApiClient


class NumbersRepository(){
    companion object{
        val instances = NumbersRepository()
        }
    fun getNumbers() : LiveData<ArrayList<NumberModel?>> =NumbersApiClient.instances.liveNumbers

    fun searchNumber() {
        NumbersApiClient.instances.searchNumber()
    }



}