package com.example.sportsfat.di

import com.example.sportsfat.data.repositoryImpl.ArticlesRepositoryImpl
import com.example.sportsfat.data.repositoryImpl.ProductsRepositoryImpl
import com.example.sportsfat.data.repositoryImpl.UserRepositoryImpl
import com.example.sportsfat.data.repositoryImpl.WorkoutsRepositoryImpl
import com.example.sportsfat.data.service.ApiService
import com.example.sportsfat.domain.articles.ArticlesRepository
import com.example.sportsfat.domain.products.ProductsRepository
import com.example.sportsfat.domain.user.UserRepository
import com.example.sportsfat.domain.workouts.WorkoutsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindArticlesRepository(
        articlesRepositoryImpl: ArticlesRepositoryImpl
    ): ArticlesRepository

    @Binds
    abstract fun bindProductsRepository(
        productsRepositoryImpl: ProductsRepositoryImpl
    ): ProductsRepository

    @Binds
    abstract fun bindWorkoutsRepository(
        workoutsRepositoryImpl: WorkoutsRepositoryImpl
    ): WorkoutsRepository

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    companion object {
        private const val BASE_URL = "https://api.jsonserve.com"


        @Provides
        fun provideApiService(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

//        @Named("SECOND")
//        @Provides
//        fun provideApiServiceSecond(@Named("SECOND") retrofit: Retrofit): ApiServiceSecond {
//            return retrofit.create(ApiServiceSecond::class.java)
//        }
//
//        @Named("SECOND")
//        @Provides
//        fun provideRetrofitInstanceSecond(): Retrofit {
//            return Retrofit.Builder()
//                .baseUrl(BASE_URL_SECOND)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
    }
}