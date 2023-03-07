package com.example.sportsfat.domain.model.workout

data class WorkoutModel(
    val name: String,
    val description: String,
    val implementationOptions: String,
    val executionTechnique: String,
    val image: Int,
    val keyWorkout: Int,
    val approaches: String,
    val repetitions: String,
    val weight: String,
    val isFavorite: Boolean
)
