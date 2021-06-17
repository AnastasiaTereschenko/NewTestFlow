package com.a.testflowproject

import android.os.Handler
import android.os.Looper

object NumberRepository {
    var numberListeners: MutableList<NumberChangedListener> = mutableListOf()
    var handler = Handler(Looper.getMainLooper())
    var number = 0

    init {
        addNumber()
    }

    private fun addNumber() {
        handler.postDelayed({
            number += 1
            numberListeners.forEach { it.onNumberChanged(number = number) }
            addNumber()
        }, 1000)
    }

    fun resetCounter() {
        number = 0
    }

    interface NumberChangedListener {
        fun onNumberChanged(number: Int)
    }

    fun setListeners(numberListener: NumberChangedListener) {
        numberListeners.add(numberListener)
    }

    fun removeListeners(numberListener: NumberChangedListener) {
        numberListeners.remove(numberListener)
    }
}