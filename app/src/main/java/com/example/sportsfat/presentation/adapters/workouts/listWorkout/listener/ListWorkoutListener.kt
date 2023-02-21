package com.example.sportsfat.presentation.adapters.workouts.listWorkout.listener

interface ListWorkoutListener {

    fun onElementSelected(name: String)

    fun onAddClicked(name: String, isFavorite: Boolean)
}