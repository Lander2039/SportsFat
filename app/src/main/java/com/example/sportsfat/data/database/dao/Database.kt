package com.example.sportsfat.data.database.dao

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sportsfat.data.database.entity.ArticlesEntity

@androidx.room.Database(entities = [ArticlesEntity::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun getItemsDAO(): ArticlesDAO

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