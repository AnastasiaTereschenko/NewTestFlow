package com.a.testflowproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberViewModel : NumberRepository.NumberChangedListener, ViewModel() {

    var newNumber = MutableLiveData<Int>()

    init {
        NumberRepository.setListeners(this)
    }

    override fun onNumberChanged(number: Int) {
        newNumber.postValue(number)
    }

    fun removeListener() {
        NumberRepository.removeListeners(this)
    }
}