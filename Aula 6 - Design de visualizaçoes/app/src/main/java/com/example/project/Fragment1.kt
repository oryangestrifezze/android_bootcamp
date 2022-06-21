package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

class Fragment1 : Fragment(R.layout.fragment_1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.text_fragment_1)
        val button = view.findViewById<Button>(R.id.button_fragment_1)

        setFragmentResultListener("requestKey") { key, bundle ->
            val result = bundle.getString("bundlekey")
            text.text = result
        }


        button.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment2("Ory", 30)
                findNavController().navigate(action)
            }

    }
}