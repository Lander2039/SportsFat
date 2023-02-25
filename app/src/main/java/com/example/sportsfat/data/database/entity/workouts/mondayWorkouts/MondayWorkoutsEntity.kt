package com.example.sportsfat.data.database.entity.workouts.mondayWorkouts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("MondayWorkoutsEntity")
data class MondayWorkoutsEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("implementationOptions")
    val implementationOptions: String,
    @ColumnInfo("executionTechnique")
    val executionTechnique: String,
    @ColumnInfo("image")
    val image: Int,
    @ColumnInfo("keyWorkout")
    val keyWorkout: Int,
    @ColumnInfo("approaches")
    val approaches: String,
    @ColumnInfo("repetitions")
    val repetitions: String,
)