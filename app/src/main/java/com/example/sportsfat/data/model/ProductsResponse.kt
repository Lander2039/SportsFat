package com.example.sportsfat.data.model

import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("sample")
    val sampleList: List<Products>
)

data class Products(
    @SerializedName("name")
    val name: String,
    @SerializedName("calories")
    val calories: Double,
    @SerializedName("squirrels")
    val squirrels: Double,
    @SerializedName("fats")
    val fats: Double,
    @SerializedName("carbohydrates")
    val carbohydrates: Double
)

