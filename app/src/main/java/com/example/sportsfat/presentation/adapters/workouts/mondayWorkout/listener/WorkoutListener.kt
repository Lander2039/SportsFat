package com.example.sportsfat.presentation.adapters.workouts.mondayWorkout.listener

interface WorkoutListener {

    fun onElementSelected(name: String)

    fun deleteWorkout(name: String)
}