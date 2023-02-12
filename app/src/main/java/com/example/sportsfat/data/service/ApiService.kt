package com.example.sportsfat.data.service

import com.example.sportsfat.data.model.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/UBpqPl")
    suspend fun getData(): Response<ArticlesResponse>
}