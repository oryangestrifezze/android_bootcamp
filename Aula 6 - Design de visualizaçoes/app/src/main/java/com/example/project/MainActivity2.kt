package com.example.project

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button = findViewById<Button>(R.id.button_voltar)
        val text = findViewById<TextView>(R.id.textView2)

        intent.extras?.let { it ->
            val nome = it.getString("nome")
            text.text = nome
        }


        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("nome2", "Valor enviado da Activity 2")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}