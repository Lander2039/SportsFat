package com.example.sportsfat.presentation.adapters.workouts.mondayWorkout.listener

interface WorkoutListener {

    fun onElementSelected(name: String, description: String, implementationOptions: String, executionTechnique: String,image: Int, approaches: String,repetitions: String)

    fun deleteWorkout(name: String)

    fun addApproachesAndRepetitions(name: String, approaches: String)
}