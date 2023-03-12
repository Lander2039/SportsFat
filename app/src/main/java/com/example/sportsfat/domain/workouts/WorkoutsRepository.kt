package com.example.sportsfat.domain.workouts

import com.example.sportsfat.domain.model.workout.TrainingDayModel
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

    suspend fun saveApproaches(
        name: String,
        approaches: String,
        repetitions: String,
        weight: String
    )
    suspend fun saveTrainingDay(trainingDayModel: TrainingDayModel)
    suspend fun showTrainingDay(): TrainingDayModel
    suspend fun saveTrainingDay1(id: Int, firstDay: String)
    suspend fun saveTrainingDay2(
        id: Int,
        secondDay: String
    )
    suspend fun saveTrainingDay3(
        id: Int,
        theThirdDay: String
    )
    suspend fun saveTrainingDay4(
        id: Int,
        fourthDay: String
    )
    suspend fun saveTrainingDay5(
        id: Int,
        fifthDay: String
    )
    suspend fun saveTrainingDay6(
        id: Int,
        sixthDay: String
    )
    suspend fun saveTrainingDay7(
        id: Int,
        seventhDay: String
    )
}