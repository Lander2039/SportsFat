package com.example.sportsfat.di

import com.example.sportsfat.domain.articles.ArticlesInteractor
import com.example.sportsfat.domain.articles.ArticlesRepository
import com.example.sportsfat.domain.products.ProductsInteractor
import com.example.sportsfat.domain.products.ProductsRepository
import com.example.sportsfat.domain.user.UserInteractor
import com.example.sportsfat.domain.user.UserRepository
import com.example.sportsfat.domain.workouts.WorkoutsInteractor
import com.example.sportsfat.domain.workouts.WorkoutsRepository
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

    @Provides
    fun provideProductsInteractor(productsRepository: ProductsRepository): ProductsInteractor {
        return ProductsInteractor(productsRepository)
    }

    @Provides
    fun provideWorkoutInteractor(workoutsRepository: WorkoutsRepository): WorkoutsInteractor {
        return WorkoutsInteractor(workoutsRepository)
    }

    @Provides
    fun provideUserInteractor(userRepository: UserRepository): UserInteractor {
        return UserInteractor(userRepository)
    }
}