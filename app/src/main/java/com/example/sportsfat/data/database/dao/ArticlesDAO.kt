package com.example.sportsfat.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sportsfat.data.database.entity.ArticlesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticlesDAO {
    @Insert
    fun insertArticlesEntity(articlesEntity: ArticlesEntity)

    @Query("SELECT * From articlesEntity ")
    fun getArticlesEntities(): Flow<List<ArticlesEntity>>

    @Query("SELECT (SELECT COUNT(*) FROM articlesEntity) != 0")
    fun doesArticlesEntityExist(): Boolean
}