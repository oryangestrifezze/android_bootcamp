package com.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.project.RetrofitServices.Companion.createPostService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var a :List<PostEntity> = emptyList<PostEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create do serviço
        val service = RetrofitServices.createPostService()

        val call =  service.list()
        //call.execute()

        call.enqueue(object : Callback<List<PostEntity>> {
            override fun onResponse(
                call: Call<List<PostEntity>>, response: Response<List<PostEntity>>) {
                if(response.isSuccessful) {
                    response.body()?.let {
                        findViewById<TextView>(R.id.text_hello).text = it[0].title
                        a = it
                    }
                }
            }

            override fun onFailure(call: Call<List<PostEntity>>, t: Throwable) {
                val s = ""
            }
        })

    }
}


//https://dog.ceo/