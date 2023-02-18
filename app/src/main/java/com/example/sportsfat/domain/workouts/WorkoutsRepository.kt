package com.example.sportsfat.domain.workouts

import com.example.sportsfat.domain.model.WorkoutModel
import kotlinx.coroutines.flow.Flow

interface WorkoutsRepository {

    suspend fun getData()

    suspend fun showData(): Flow<List<WorkoutModel>>
}