package com.example.sportsfat.domain.products

import com.example.sportsfat.domain.model.ProductsModel
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    suspend fun getData()

    suspend fun showData(): Flow<List<ProductsModel>>

    suspend fun findProductByName(searchText: String): ProductsModel

}