package com.project

import retrofit2.http.GET
import  retrofit2.http.Headers

//Aqui todas as rotas que vou precisar
interface PostService {

    @Headers("Authorization: APP_USR-2200225733175765-062714-64a65ceba11d58fbc4b71800ac42a640-795944208")
    @GET("posts")
    suspend fun fetchPosts(): List<PostResponse>

}