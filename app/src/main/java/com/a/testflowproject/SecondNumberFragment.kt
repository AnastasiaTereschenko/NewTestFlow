package com.a.testflowproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_second_number.*
import kotlinx.coroutines.flow.collect

class SecondNumberFragment : Fragment() {
    var secondNumberViewModel = SecondNumberViewModel()

    companion object {
        const val NUMBER = "number"

        @JvmStatic
        fun newInstance(number: Int): SecondNumberFragment {
            val args = Bundle()
            args.putInt(NUMBER, number)
            val fragment = SecondNumberFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("", "")
        secondNumberViewModel = SecondNumberViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenStarted {
            secondNumberViewModel.newNumber.collect { number ->
                if (number != 0) {
                    secondNumberTextView.text = number.toString()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        secondNumberViewModel.removeListener()
    }
}