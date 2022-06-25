package com.project

import androidx.viewbinding.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Classe config retrofit
class RetrofitServices {

    companion object {

    private  lateinit var  INSTANCE : Retrofit
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private fun getRetrofitInstance() : Retrofit {
            val http = OkHttpClient.Builder() //conecta com a internet - retrofit usa para conectar
           if(!::INSTANCE.isInitialized) {
               INSTANCE = Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .client(http.build()) //faz a chamada para internet
                   .addConverterFactory(GsonConverterFactory.create()) //converte após chamada
                   .build() // builda "pode instanciar"
           }
            return  INSTANCE
        }

        fun createPostService() : PostService {
            return getRetrofitInstance().create(PostService::class.java)
        }
    }

}