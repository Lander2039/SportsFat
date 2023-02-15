package com.example.sportsfat.domain.model

import com.google.gson.annotations.SerializedName

data class ProductsModel(
    val id: Int,
    val name: String,
    val calories: Double,
    val squirrels: Double,
    val fats: Double,
    val carbohydrates: Double
)
