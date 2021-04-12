package com.a.testflowproject

import android.os.Handler
import android.os.Looper

object NumberRepository {
    var numberChangedListener: NumberChangedListener? = null
    var handler = Handler(Looper.getMainLooper())
    var number = 0

    init {
        addNumber()
    }

    fun addNumber() {
        handler.postDelayed({
            number += 1
            numberChangedListener?.onNumberChanged(number = number)
            addNumber()
        }, 1000)
    }

    interface NumberChangedListener {
        fun onNumberChanged(number: Int)
    }
}