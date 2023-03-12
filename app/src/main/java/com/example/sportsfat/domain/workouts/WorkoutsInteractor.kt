package com.example.sportsfat.domain.workouts

import com.example.sportsfat.domain.model.workout.TrainingDayModel
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

    suspend fun getMondayWorkouts(): Flow<List<MondayWorkoutModel>> {
        return workoutsRepository.getMondayWorkouts()
    }

    suspend fun onAddMondayWorkouts(name: String, isFavorite: Boolean) {
        val foundItem = workoutsRepository.findWorkoutEntityByName(name)
        workoutsRepository.addMondayWorkouts(foundItem, isFavorite)
    }

    suspend fun deleteWorkoutByName(name: String) {
        workoutsRepository.deleteWorkoutByName(name)
    }

    suspend fun saveApproaches(
        name: String,
        approaches: String,
        repetitions: String,
        weight: String
    ) {
        workoutsRepository.saveApproaches(name, approaches, repetitions, weight)
    }

    suspend fun saveTrainingDay(trainingDayModel: TrainingDayModel) {
        return workoutsRepository.saveTrainingDay(trainingDayModel)
    }

    suspend fun showTrainingDay(): TrainingDayModel {
        return workoutsRepository.showTrainingDay()
    }

    suspend fun saveTrainingDay1(
        id: Int,
        firstDay: String
    ) {
        return workoutsRepository.saveTrainingDay1(id, firstDay)
    }

    suspend fun saveTrainingDay2(
        id: Int,
        secondDay: String
    ) {
        return workoutsRepository.saveTrainingDay2(id, secondDay)
    }

    suspend fun saveTrainingDay3(
        id: Int,
        theThirdDay: String
    ) {
        return workoutsRepository.saveTrainingDay3(id, theThirdDay)
    }

    suspend fun saveTrainingDay4(
        id: Int,
        fourthDay: String
    ) {
        return workoutsRepository.saveTrainingDay4(id, fourthDay)
    }

    suspend fun saveTrainingDay5(
        id: Int,
        fifthDay: String
    ) {
        return workoutsRepository.saveTrainingDay5(id, fifthDay)
    }

    suspend fun saveTrainingDay6(
        id: Int,
        sixthDay: String
    ) {
        return workoutsRepository.saveTrainingDay6(id, sixthDay)
    }

    suspend fun saveTrainingDay7(
        id: Int,
        seventhDay: String
    ) {
        return workoutsRepository.saveTrainingDay7(id, seventhDay)
    }
}