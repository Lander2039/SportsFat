package com.example.sportsfat.data.model

import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("articles")
    val articlesList: List<Articles>
)

data class Articles(
    @SerializedName("articlesName")
    val articlesName: String,
    @SerializedName("articlesText")
    val articlesText: String,
    @SerializedName("imageUrl")
    val imageUrl: String
)
