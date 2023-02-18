package com.example.sportsfat.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sportsfat.data.database.entity.ArticlesEntity
import com.example.sportsfat.data.database.entity.ProductsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {
    @Insert
    fun insertArticlesEntity(articlesEntity: ArticlesEntity)

    @Query("SELECT * From articlesEntity ")
    fun getArticlesEntities(): Flow<List<ArticlesEntity>>

    @Query("SELECT (SELECT COUNT(*) FROM articlesEntity) != 0")
    fun doesArticlesEntityExist(): Boolean

    @Insert
    fun insertProductsEntity(productsEntity: ProductsEntity)

    @Query("SELECT * From productsEntity ")
    fun getProductsEntities(): Flow<List<ProductsEntity>>

    @Query("SELECT * FROM productsEntity WHERE name = :searchText")
    fun findProductsEntityByDescription(searchText: String): ProductsEntity
}