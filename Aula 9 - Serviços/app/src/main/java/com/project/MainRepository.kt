package com.project

import retrofit2.Retrofit

//padrao para lidar com dados(db/api) - o mesmo repository para todos os gets

class MainRepository {
    //so usando a funcao
    private val service : PostService = RetrofitServices.createPostService()

    //queremos que fique em bg em outra thread por desempenho
   suspend fun getPosts() : List<PostResponse>{
      return  service.fetchPosts()
    }
}