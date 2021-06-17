package com.a.testflowproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SecondNumberViewModel : NumberRepository.NumberChangedListener, ViewModel() {

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