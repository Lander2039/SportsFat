package com.example.sportsfat.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("ProductsEntity")
data class ProductsEntity(
     @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("calories")
     val calories: Double,
    @ColumnInfo("squirrels")
    val squirrels: Double,
     @ColumnInfo("fats")
     val fats: Double,
     @ColumnInfo("carbohydrates")
     val carbohydrates: Double,
     )
