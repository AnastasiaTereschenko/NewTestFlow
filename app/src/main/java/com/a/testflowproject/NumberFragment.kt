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
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberViewModel = NumberViewModel()
        numberTextView.text = ""
        numberViewModel?.newNumber?.observe(this as LifecycleOwner, Observer {
            numberTextView.text = it.toString()
        } )
    }
}