package com.example.project

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class Fragment2 : Fragment(R.layout.fragment_2) {
    private var name: String? = ""
    private var age: Int? = 0
    val args: Fragment2Args by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            name = args.name
            age = args.age
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = view.findViewById<TextView>(R.id.text_fragment_2)
        val button = view.findViewById<Button>(R.id.button_fragment_2)

        button.setOnClickListener {
            val result = "Novo Valor Setado"
            setFragmentResult("requestKey", bundleOf("bundlekey" to result))
            findNavController().navigate(Uri.parse("cursoandroid://card"))
        }

        text.text = "O nome é $name e sua idade é $age anos"
    }

    companion object {
        private const val NAME_ = "name"
        private const val AGE_ = "age"

        fun newInstance(name:String, age:Int) = Fragment2().apply {
            arguments = bundleOf(NAME_ to name, AGE_ to age)
        }
    }
}