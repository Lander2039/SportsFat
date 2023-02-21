package com.example.sportsfat.domain.model

data class WorkoutModel(
    val name: String,
    val description: String,
    val implementationOptions: String,
    val executionTechnique: String,
    val image: Int,
    val keyWorkout: Int,
    val approaches: Int,
    val repetitions: Int
    )
