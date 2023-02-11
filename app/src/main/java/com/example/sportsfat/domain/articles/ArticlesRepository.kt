package com.example.sportsfat.domain.articles

import com.example.sportsfat.domain.model.ArticlesModel
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {

    suspend fun getData()

    suspend fun showData(): Flow<List<ArticlesModel>>
}