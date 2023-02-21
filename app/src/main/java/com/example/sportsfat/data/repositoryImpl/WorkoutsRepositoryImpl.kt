package com.example.sportsfat.data.repositoryImpl

import com.example.sportsfat.data.database.dao.DAO
import com.example.sportsfat.data.database.entity.workouts.listWorkouts.WorkoutEntity
import com.example.sportsfat.domain.model.WorkoutModel
import com.example.sportsfat.domain.workouts.WorkoutsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class WorkoutsRepositoryImpl @Inject constructor(
    private val DAO: DAO
) : WorkoutsRepository {

    fun getWorkouts(): List<WorkoutModel> {
        val listWorkout = listOf<WorkoutModel>(
            WorkoutModel(
                name = "Жим Лежа1",
                description = "Жим лёжа — базовое физическое упражнение со свободным весом. Выполняющий упражнение ложится на скамейку, опускает гриф до касания с грудью и поднимает до полного выпрямления в локтевом суставе. Используется в бодибилдинге как упражнение для развития больших и малых грудных мышц, трицепсов и переднего пучка дельтовидной мышцы.",
                implementationOptions = "",
                executionTechnique = "2",
                image = 10,
                keyWorkout = 1,
                approaches = 1,
                repetitions = 1
            ),
            WorkoutModel(
                name = "Жим Лежа2",
                description = "Жим лёжа — базовое физическое упражнение со свободным весом. Выполняющий упражнение ложится на скамейку, опускает гриф до касания с грудью и поднимает до полного выпрямления в локтевом суставе. Используется в бодибилдинге как упражнение для развития больших и малых грудных мышц, трицепсов и переднего пучка дельтовидной мышцы.",
                implementationOptions = " — двух-трёх страхующих.",
                executionTechnique = "33",
                image = 5,
                keyWorkout = 1,
                approaches = 1,
                repetitions = 1
            ),
            WorkoutModel(
                name = "Жим Лежа3",
                description = "Жим лёжа — базовое физическое упражнение со свободным весом. Выполняющий упражнение ложится на скамейку, опускает гриф до касания с грудью и поднимает до полного выпрямления в локтевом суставе. Используется в бодибилдинге как упражнение для развития больших и малых грудных мышц, трицепсов и переднего пучка дельтовидной мышцы.",
                implementationOptions = " — двух-трёх страхующих.",
                executionTechnique = "44",
                image = 9,
                keyWorkout = 1,
                approaches = 1,
                repetitions = 1
            ),
            WorkoutModel(
                name = "Жим Лежа5",
                description = "Жим лёжа — базовое физическое упражнение со свободным весом. Выполняющий упражнение ложится на скамейку, опускает гриф до касания с грудью и поднимает до полного выпрямления в локтевом суставе. Используется в бодибилдинге как упражнение для развития больших и малых грудных мышц, трицепсов и переднего пучка дельтовидной мышцы.",
                implementationOptions = " — двух-трёх страхующих.",
                executionTechnique = "55",
                image = 4,
                keyWorkout = 1,
                approaches = 1,
                repetitions = 1
            ),
        )
        return listWorkout
    }

    override suspend fun getData() {
        return withContext(Dispatchers.IO) {
            if (!DAO.doesWorkoutsEntityExist()) {
                val workouts = getWorkouts()
                workouts.map { workoutsList ->
                    val workoutsEntity =
                        WorkoutEntity(
                            Random().nextInt(),
                            workoutsList.name,
                            workoutsList.description,
                            workoutsList.implementationOptions,
                            workoutsList.executionTechnique,
                            workoutsList.image,
                            workoutsList.keyWorkout,
                            workoutsList.approaches,
                            workoutsList.repetitions
                        )
                    DAO.insertWorkoutsEntity(workoutsEntity)
                }
            }
        }
    }

    override suspend fun showData(): Flow<List<WorkoutModel>> {
        return withContext(Dispatchers.IO) {
            val workoutsEntity = DAO.getWorkoutsEntities()
            workoutsEntity.map { workoutsList ->
                workoutsList.map {
                    WorkoutModel(
                        it.name,
                        it.description,
                        it.implementationOptions,
                        it.executionTechnique,
                        it.image,
                        it.keyWorkout,
                        it.approaches,
                        it.repetitions
                    )
                }
            }
        }
    }

}