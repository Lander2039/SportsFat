package com.example.sportsfat.domain.articles

import com.example.sportsfat.domain.model.ArticlesModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticlesInteractor @Inject constructor(private val articlesRepository: ArticlesRepository) {

    suspend fun getData() {
        return articlesRepository.getData()
    }

    suspend fun showData(): Flow<List<ArticlesModel>> {
        return articlesRepository.showData()
    }
}