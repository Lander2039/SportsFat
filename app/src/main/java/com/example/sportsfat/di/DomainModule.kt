package com.example.sportsfat.di

import com.example.sportsfat.domain.articles.ArticlesInteractor
import com.example.sportsfat.domain.articles.ArticlesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideArticlesInteractor(articlesRepository: ArticlesRepository): ArticlesInteractor {
        return ArticlesInteractor(articlesRepository)
    }
}