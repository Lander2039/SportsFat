package com.example.sportsfat.data.service

import com.example.sportsfat.data.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceSecond {

    @GET("/_VbxFs")
    suspend fun getDataProducts(): Response<ProductsResponse>
}