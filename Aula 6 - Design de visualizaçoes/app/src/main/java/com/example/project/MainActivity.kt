package com.example.project

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Lifecycle

class MainActivity : AppCompatActivity() {
    private lateinit var text:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button_enviar)

        button.setOnClickListener {
            navegarSegundaActivity()
        }
    }

    private fun navegarSegundaActivity() {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("nome", "Valor enviado da Activity 1")
        //startActivity(intent)
            startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                val nome = data?.getStringExtra("nome2")
                text.text = nome
            }
        }
    }

//    override fun onStart() {
//        super.onStart()
//        Log.d("LifeCycle", "onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("LifeCycle", "onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("LifeCycle", "onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("LifeCycle", "onStop")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d("LifeCycle", "onRestart")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("LifeCycle", "onDestroy")
//    }
}