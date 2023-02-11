package com.example.sportsfat.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("ArticlesEntity")
data class ArticlesEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("articlesName")
    val articlesName: String,
    @ColumnInfo("articlesText")
    val articlesText: String,
    @ColumnInfo("image-Url")
    val imageUrl: String
)
