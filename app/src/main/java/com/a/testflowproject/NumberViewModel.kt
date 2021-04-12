package com.a.testflowproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberViewModel : NumberRepository.NumberChangedListener, ViewModel() {

    var newNumber: MutableLiveData<Int>? = MutableLiveData<Int>()

    init {
        NumberRepository.numberChangedListener = this
    }

    override fun onNumberChanged(number: Int) {
        newNumber?.value = number
    }
}