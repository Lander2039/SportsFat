package com.example.sportsfat.domain.products

import com.example.sportsfat.domain.model.ProductsModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsInteractor @Inject constructor(private val productsRepository: ProductsRepository) {

    suspend fun getData() {
        return productsRepository.getData()
    }

    suspend fun showData(): Flow<List<ProductsModel>> {
        return productsRepository.showData()
    }

    suspend fun findProduct(searchText: String): ProductsModel {
        return productsRepository.findProductByName(searchText)
    }
}
