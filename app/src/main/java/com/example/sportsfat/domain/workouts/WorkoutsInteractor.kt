package com.example.sportsfat.domain.workouts

import com.example.sportsfat.domain.model.workout.WorkoutModel
import com.example.sportsfat.domain.model.workout.mondayWorkout.MondayWorkoutModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WorkoutsInteractor @Inject constructor(private val workoutsRepository: WorkoutsRepository) {

    suspend fun getData() {
        return workoutsRepository.getData()
    }

    suspend fun showData(): Flow<List<WorkoutModel>> {
        return workoutsRepository.showData()
    }

    suspend fun getMondayWorkouts(): Flow<List<MondayWorkoutModel>>{
        return workoutsRepository.getMondayWorkouts()
    }

    suspend fun onAddMondayWorkouts(name: String, isFavorite: Boolean) {
        val foundItem = workoutsRepository.findWorkoutEntityByName(name)
        workoutsRepository.addMondayWorkouts(foundItem, isFavorite)
    }

    suspend fun deleteWorkoutByName(name: String){
        workoutsRepository.deleteWorkoutByName(name)
    }

    suspend fun saveApproaches(name: String, approaches:String){
        workoutsRepository.saveApproaches(name, approaches)
    }

}