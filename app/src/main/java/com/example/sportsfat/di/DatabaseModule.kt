package com.example.sportsfat.di

import android.content.Context
import com.example.sportsfat.data.database.dao.DAO
import com.example.sportsfat.data.database.dao.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDao(Database: Database): DAO {
        return Database.getItemsDAO()
    }

    @Provides
    fun Database(context: Context): Database {
        return Database.getItemsDatabaseInstance(context)
    }
}