package com.project

import com.google.gson.annotations.SerializedName

//cada endpoint um response diferente

data class PostResponse (
    @SerializedName("userId")
    val userId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String,
)
