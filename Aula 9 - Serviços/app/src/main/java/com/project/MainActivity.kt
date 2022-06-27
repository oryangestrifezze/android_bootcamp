package com.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {
    val viewmodel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Quando for fragment
        viewmodel.listPosts.observe(this) {
            //Log.d("Debug", it.toString())
            findViewById<TextView>(R.id.text_hello).text = it.toString()
        }

        viewmodel.getPosts()

    }
}


