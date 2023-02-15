package com.example.sportsfat.presentation.view.fragments.products

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsfat.domain.model.ProductsModel
import com.example.sportsfat.domain.products.ProductsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor( private val productsInteractor: ProductsInteractor): ViewModel() {

    private val _product = MutableLiveData<ProductsModel>()
    val product: LiveData<ProductsModel> = _product

    fun findProduct(searchText: String) {
        viewModelScope.launch {
            try {
                val foundProduct = productsInteractor.findProduct(searchText)
                _product.value = foundProduct
            } catch (e: Exception){
                Log.w("exception", e.toString())
            }
        }
    }

}