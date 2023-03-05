package com.example.sportsfat.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("UserEntity")
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("age")
    val age: Int,
    @ColumnInfo("height")
    val height: Double,
    @ColumnInfo("weightStart")
    val weightStart: Int,
    @ColumnInfo("weightToday")
    val weightToday: Int,
    @ColumnInfo("image")
    val image: Int,
    @ColumnInfo("activityFactor")
    val activityFactor: Double,
    @ColumnInfo("bmi")
    val bmi: Int,
    @ColumnInfo("resultWeight")
    val resultWeight: Int
)