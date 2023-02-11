package com.example.sportsfat.di

import android.content.Context
import com.example.sportsfat.data.database.dao.ArticlesDAO
import com.example.sportsfat.data.database.dao.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideArticlesDao(Database: Database): ArticlesDAO{
        return Database.getItemsDAO()
    }

    @Provides
    fun articlesDatabase(context: Context) :Database{
        return Database.getItemsDatabaseInstance(context)
    }
}