package com.example.sportsfat.di

import android.content.Context
import com.example.sportsfat.data.repositoryImpl.ArticlesRepositoryImpl
import com.example.sportsfat.data.service.ApiService
import com.example.sportsfat.data.service.ApiServiceSecond
import com.example.sportsfat.data.sharedPreferemces.SharedPreferencesHelper
import com.example.sportsfat.domain.articles.ArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindArticlesRepository(
        articlesRepositoryImpl: ArticlesRepositoryImpl
    ): ArticlesRepository

    companion object {
        private const val BASE_URL = "https://api.jsonserve.com"
        private const val BASE_URL_SECOND = "https://api.jsonserve.com"

        @Named("FIRST")
        @Provides
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Named("SECOND")
        @Provides
        fun provideApiServiceSecond(@Named("SECOND") retrofit: Retrofit): ApiServiceSecond {
            return retrofit.create(ApiServiceSecond::class.java)
        }

        @Named("SECOND")
        @Provides
        fun provideRetrofitInstanceSecond(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL_SECOND)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}