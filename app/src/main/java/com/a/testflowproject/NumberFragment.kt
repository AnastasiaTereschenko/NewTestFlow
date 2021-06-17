package com.a.testflowproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_number.*
import kotlinx.android.synthetic.main.fragment_number.view.*


class NumberFragment : Fragment() {
    var numberViewModel: NumberViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        numberViewModel = NumberViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberViewModel?.newNumber?.observe(this, Observer<Int>{
            numberTextView.text = it.toString()
        })
        val mainActivity: MainActivity = requireActivity() as MainActivity
        secondNumberScreenButton.setOnClickListener { mainActivity.navigateToSecondFragment()  }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        numberViewModel?.removeListener()
    }
}