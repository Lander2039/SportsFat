package com.example.sportsfat.data.repositoryImpl

import com.example.sportsfat.data.database.dao.DAO
import com.example.sportsfat.data.database.entity.ArticlesEntity
import com.example.sportsfat.data.service.ApiService
import com.example.sportsfat.data.service.ApiServiceSecond
import com.example.sportsfat.domain.articles.ArticlesRepository
import com.example.sportsfat.domain.model.ArticlesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class ArticlesRepositoryImpl @Inject constructor(
    @Named("FIRST") private val apiService: ApiService,
    @Named("SECOND") private val apiServiceSecond: ApiServiceSecond,
    private val DAO: DAO
) : ArticlesRepository {
    override suspend fun getData() {
        return withContext(Dispatchers.IO) {
            if (!DAO.doesArticlesEntityExist()) {
                val response = apiService.getData()
                response.body()?.sampleList?.let { articlesList ->
                    articlesList.map { articles ->
                        val articlesEntity =
                            ArticlesEntity(
                                Random().nextInt(),
                                articles.description,
                                articles.imageUrl,
                                articles.articlesText
                            )
                        DAO.insertArticlesEntity(articlesEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): Flow<List<ArticlesModel>> {
        return withContext(Dispatchers.IO) {
            val articlesEntity = DAO.getArticlesEntities()
            articlesEntity.map { articlesList ->
                articlesList.map {
                    ArticlesModel(
                        it.description, it.imageUrl, it.articlesText
                    )
                }
            }
        }
    }
}