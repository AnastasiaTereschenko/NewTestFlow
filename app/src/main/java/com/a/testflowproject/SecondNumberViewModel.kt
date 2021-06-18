package com.a.testflowproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SecondNumberViewModel : NumberRepository.NumberChangedListener, ViewModel() {

    var _newNumber = MutableStateFlow<Int>(0)

    var newNumber: StateFlow<Int> = _newNumber

    init {
        NumberRepository.setListeners(this)
    }

    override fun onNumberChanged(number: Int) {
        _newNumber.value = number
    }

    fun removeListener() {
        NumberRepository.removeListeners(this)
    }
}