package com.example.sportsfat.presentation.adapters.workouts.listWorkout.listener

interface ListWorkoutListener {

    fun onElementSelected(name: String, description: String, implementationOptions: String, executionTechnique: String,image: Int)

    fun onAddClicked(name: String, isFavorite: Boolean)
}