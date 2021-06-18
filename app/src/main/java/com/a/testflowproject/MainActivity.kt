package com.a.testflowproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val FIRST_FR = "first_fr"
        const val SECOND_FR = "second_fr"
    }

    init {
        NumberRepository.resetCounter()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToFirstFragment()

    }

    fun navigateToFirstFragment () {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.amContainer, NumberFragment(), FIRST_FR)
        ft.commit()
    }

    fun navigateToSecondFragment () {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.amContainer, SecondNumberFragment(), SECOND_FR)
        ft.addToBackStack(null)
        ft.commit()
    }
}