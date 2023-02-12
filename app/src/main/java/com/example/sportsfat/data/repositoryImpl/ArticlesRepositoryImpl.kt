package com.example.sportsfat.data.repositoryImpl

import com.example.sportsfat.data.database.dao.ArticlesDAO
import com.example.sportsfat.data.database.entity.ArticlesEntity
import com.example.sportsfat.data.service.ApiService
import com.example.sportsfat.domain.articles.ArticlesRepository
import com.example.sportsfat.domain.model.ArticlesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class ArticlesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val articlesDAO: ArticlesDAO
) : ArticlesRepository {
    override suspend fun getData() {
        return withContext(Dispatchers.IO) {
            if (!articlesDAO.doesArticlesEntityExist()) {
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
                        articlesDAO.insertArticlesEntity(articlesEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): Flow<List<ArticlesModel>> {
        return withContext(Dispatchers.IO) {
            val articlesEntity = articlesDAO.getArticlesEntities()
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