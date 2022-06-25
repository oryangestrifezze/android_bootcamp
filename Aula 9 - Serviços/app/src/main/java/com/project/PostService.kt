package com.project

import retrofit2.Call
import retrofit2.http.GET

//Repository

interface PostService {

    @GET("posts")
    fun list(): Call<List<PostEntity>>
}