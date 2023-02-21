package com.example.sportsfat.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sportsfat.data.database.entity.ArticlesEntity
import com.example.sportsfat.data.database.entity.ProductsEntity
import com.example.sportsfat.data.database.entity.workouts.listWorkouts.WorkoutEntity
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

    @Insert(onConflict = OnConflictStrategy.IGNORE) // игнорирование если они одинаковы
    fun insertFavoritesEntity(favoritesEntity: FavoritesEntity)

    @Query("UPDATE ItemsEntity SET isFavorite = :isFavorite WHERE description = :description")
    fun addToFavorite(description: String, isFavorite: Boolean)

    @Query("SELECT * FROM favoritesEntity")
    fun getFavoritesEntity(): List<FavoritesEntity>
}