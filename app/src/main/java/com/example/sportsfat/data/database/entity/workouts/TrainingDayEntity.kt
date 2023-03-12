package com.example.sportsfat.data.database.entity.workouts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("TrainingDayEntity")
data class TrainingDayEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("firstDay")
    val firstDay: String,
    @ColumnInfo("secondDay")
    val secondDay: String,
    @ColumnInfo("theThirdDay")
    val theThirdDay: String,
    @ColumnInfo("fourthDay")
    val fourthDay: String,
    @ColumnInfo("fifthDay")
    val fifthDay: String,
    @ColumnInfo("sixthDay")
    val sixthDay: String,
    @ColumnInfo("seventhDay")
    val seventhDay: String,

)
