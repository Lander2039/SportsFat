package com.example.sportsfat.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sportsfat.data.database.entity.ArticlesEntity
import com.example.sportsfat.data.database.entity.ProductsEntity
import com.example.sportsfat.data.database.entity.UserEntity
import com.example.sportsfat.data.database.entity.workouts.listWorkouts.WorkoutEntity
import com.example.sportsfat.data.database.entity.workouts.mondayWorkouts.MondayWorkoutsEntity
import com.example.sportsfat.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {
    @Insert
    fun insertArticlesEntity(articlesEntity: ArticlesEntity)

    @Query("SELECT * From articlesEntity ")
    fun getArticlesEntities(): Flow<List<ArticlesEntity>>

    @Query("SELECT (SELECT COUNT(*) FROM articlesEntity) != 0")
    fun doesArticlesEntityExist(): Boolean

    @Insert
    fun insertProductsEntity(productsEntity: ProductsEntity)

    @Query("SELECT * From productsEntity ")
    fun getProductsEntities(): Flow<List<ProductsEntity>>

    @Query("SELECT * FROM productsEntity WHERE name = :searchText")
    fun findProductsEntityByDescription(searchText: String): ProductsEntity

    @Insert
    fun insertWorkoutsEntity(workoutEntity: WorkoutEntity)

    @Query("SELECT * From WorkoutEntity ")
    fun getWorkoutsEntities(): Flow<List<WorkoutEntity>>

    @Query("SELECT (SELECT COUNT(*) FROM WorkoutEntity) != 0")
    fun doesWorkoutsEntityExist(): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMondayWorkoutsEntity(mondayWorkoutsEntity: MondayWorkoutsEntity)

    @Query("UPDATE WorkoutEntity SET isFavorite = :isFavorite WHERE name = :name")
    fun addToWorkouts(name: String, isFavorite: Boolean)

    @Query("SELECT * FROM MondayWorkoutsEntity")
    fun getMondayWorkoutsEntity(): Flow<List<MondayWorkoutsEntity>>

    @Query("DELETE FROM MondayWorkoutsEntity WHERE name =:name")
    fun deleteWorkoutEntityByName(name: String)

    @Query("SELECT * FROM WorkoutEntity WHERE name = :searchText")
    fun findWorkoutEntityByName(searchText: String): WorkoutEntity

    @Query("UPDATE MondayWorkoutsEntity SET approaches =:approaches, repetitions =:repetitions, weight =:weight   WHERE name =:name")
    fun saveApproaches(name: String, approaches: String, repetitions: String, weight: String)

    @Insert
    fun insertUserEntity(userEntity: UserEntity)

    @Query("SELECT * From UserEntity")
    fun getUserEntities(): UserModel

    @Query("UPDATE UserEntity SET name =:name, age =:age, height =:height, weightStart =:weightStart, activityFactor =:activityFactor, bmi =:bmi WHERE name =:name")
    fun updateUserDate(name: String, age: Int, height: Double, weightStart: Int, activityFactor: Double,bmi: Int)

    @Query("UPDATE UserEntity SET name =:name, weightToday =:weightToday WHERE name =:name")
    fun updateUserDateToday(name: String, weightToday: Int)

}