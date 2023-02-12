package com.example.sportsfat.data.model

import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("sample")
    val sampleList: List<Articles>
)

data class Articles(
    @SerializedName("description")
    val description: String,

    @SerializedName("image-url")
    val imageUrl: String,

    @SerializedName("articlesText")
    val articlesText: String,
)
