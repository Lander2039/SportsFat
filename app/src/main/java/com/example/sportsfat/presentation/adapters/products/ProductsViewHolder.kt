package com.example.sportsfat.presentation.adapters.products

import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListProductBinding
import com.example.sportsfat.domain.model.ProductsModel

class ProductsViewHolder(
    private val viewBinding: ListProductBinding

) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(productsModel: ProductsModel) {
        viewBinding.tvNameProduct.text = productsModel.name
        viewBinding.tvCaloriesProduct.text = productsModel.calories.toString()
        viewBinding.tvSquirrelsProduct.text = productsModel.squirrels.toString()
        viewBinding.tvFatsProduct.text = productsModel.fats.toString()
        viewBinding.tvCarbohydratesProduct.text = productsModel.carbohydrates.toString()
    }
}