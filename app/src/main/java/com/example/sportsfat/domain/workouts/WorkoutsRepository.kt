package com.example.sportsfat.domain.workouts

import com.example.sportsfat.domain.model.workout.WorkoutModel
import com.example.sportsfat.domain.model.workout.mondayWorkout.MondayWorkoutModel
import kotlinx.coroutines.flow.Flow

interface WorkoutsRepository {

    suspend fun getData()

    suspend fun showData(): Flow<List<WorkoutModel>>

    suspend fun addMondayWorkouts(
        workoutModel: WorkoutModel,
        isFavorite: Boolean
    )

    suspend fun getMondayWorkouts(): Flow<List<MondayWorkoutModel>>

    suspend fun deleteWorkoutByName(name: String)

    suspend fun findWorkoutEntityByName(searchText: String): WorkoutModel

    suspend fun saveApproaches(name: String, approaches:String, repetitions: String, weight: String)
}