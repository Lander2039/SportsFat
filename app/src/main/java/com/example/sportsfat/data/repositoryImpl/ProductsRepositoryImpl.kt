package com.example.sportsfat.data.repositoryImpl

import com.example.sportsfat.data.database.dao.DAO
import com.example.sportsfat.data.database.entity.ProductsEntity
import com.example.sportsfat.data.service.ApiService
import com.example.sportsfat.domain.model.ProductsModel
import com.example.sportsfat.domain.products.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val DAO: DAO
) : ProductsRepository {
    override suspend fun getData() {
        return withContext(Dispatchers.IO) {
            if (!DAO.doesArticlesEntityExist()) {
                val response = apiService.getDataProducts()
                response.body()?.sampleList?.let { productsList ->
                    productsList.map { product ->
                        val productsEntity =
                            ProductsEntity(
                                Random().nextInt(),
                                product.name,
                                product.calories,
                                product.squirrels,
                                product.fats,
                                product.carbohydrates
                            )
                        DAO.insertProductsEntity(productsEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): Flow<List<ProductsModel>> {
        return withContext(Dispatchers.IO) {
            val productsEntity = DAO.getProductsEntities()
            productsEntity.map { productsList ->
                productsList.map {
                    ProductsModel(
                        it.name, it.calories, it.squirrels, it.fats, it.carbohydrates
                    )
                }
            }
        }
    }

    override suspend fun findProductByName(searchText: String): ProductsModel {
        return withContext(Dispatchers.IO) {
            val productsEntity = DAO.findProductsEntityByDescription(searchText)
            ProductsModel(
                productsEntity.name,
                productsEntity.calories,
                productsEntity.squirrels,
                productsEntity.fats,
                productsEntity.carbohydrates
            )
        }
    }
}