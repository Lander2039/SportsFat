package com.example.sportsfat.data.repositoryImpl

import com.example.sportsfat.data.database.dao.DAO
import com.example.sportsfat.domain.articles.ArticlesRepository
import com.example.sportsfat.domain.model.ArticlesModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WorkoutsRepositoryImpl @Inject constructor(
    private val DAO: DAO
) : ArticlesRepository {
    override suspend fun getData() {

    }

    override suspend fun showData(): Flow<List<ArticlesModel>> {

    }
}