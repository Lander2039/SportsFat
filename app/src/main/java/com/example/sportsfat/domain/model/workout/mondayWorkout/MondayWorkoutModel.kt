package com.example.sportsfat.domain.model.workout.mondayWorkout

data class MondayWorkoutModel(
    val name: String,
    val description: String,
    val implementationOptions: String,
    val executionTechnique: String,
    val image: Int,
    val keyWorkout: Int,
    val approaches: String,
    val repetitions: String,
    val weight: String
)
