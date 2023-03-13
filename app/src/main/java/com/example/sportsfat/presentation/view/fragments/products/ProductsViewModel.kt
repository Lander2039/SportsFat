package com.example.sportsfat.presentation.view.fragments.products

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsfat.domain.model.ProductsModel
import com.example.sportsfat.domain.products.ProductsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val productsInteractor: ProductsInteractor) :
    ViewModel() {

    val products = flow { emit(productsInteractor.showData()) }

    private val _product = MutableLiveData<ProductsModel>()
    val product: LiveData<ProductsModel> = _product

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getDataProducts() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    productsInteractor.getData()
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "getDataProducts")
            }
        }
    }

    fun findProduct(searchText: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    val foundProduct = productsInteractor.findProduct(searchText)
                    _product.value = foundProduct
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "findProduct")
            }
        }
    }
}