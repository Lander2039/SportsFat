package com.example.sportsfat.data.database.dao

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sportsfat.data.database.entity.ArticlesEntity
import com.example.sportsfat.data.database.entity.ProductsEntity
import com.example.sportsfat.data.database.entity.workouts.listWorkouts.WorkoutEntity
import com.example.sportsfat.data.database.entity.workouts.mondayWorkouts.MondayWorkoutsEntity

@androidx.room.Database(entities = [ArticlesEntity::class, ProductsEntity::class, WorkoutEntity::class, MondayWorkoutsEntity::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun getItemsDAO(): DAO

    companion object {
        private var DB_INSTANCE: Database? = null

        fun getItemsDatabaseInstance(context: Context): Database {
            return DB_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    Database::class.java,
                    "Items_DB"
                )
                .fallbackToDestructiveMigration()

                .build()
                .also { DB_INSTANCE = it }
        }
    }
}