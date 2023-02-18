package com.example.sportsfat.domain.workouts

import com.example.sportsfat.domain.model.WorkoutModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WorkoutsInteractor @Inject constructor(private val workoutsRepository: WorkoutsRepository) {

    suspend fun getData() {
        return workoutsRepository.getData()
    }

    suspend fun showData(): Flow<List<WorkoutModel>> {
        return workoutsRepository.showData()
    }
}