package com.numbergrid.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.numbergrid.model.NumberModel
import com.numbergrid.repositories.NumbersRepository
import com.numbergrid.request.NumbersApiClient

//ViewModel Class
class NumbersViewModel() : ViewModel() {

    fun getNumbers() : LiveData<ArrayList<NumberModel?>> = NumbersRepository.instances.getNumbers()

    fun searchNumber() {
        NumbersRepository.instances.searchNumber()
    }

}