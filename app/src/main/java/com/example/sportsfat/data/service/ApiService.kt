package com.example.sportsfat.data.service

import com.example.sportsfat.data.model.ArticlesResponse
import com.example.sportsfat.data.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/UBpqPl")
    suspend fun getData(): Response<ArticlesResponse>

    @GET("/_VbxFs")
    suspend fun getDataProducts(): Response<ProductsResponse>
}