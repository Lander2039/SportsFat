package com.example.sportsfat.presentation.adapters.products

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsfat.databinding.ListProductBinding
import com.example.sportsfat.domain.model.ProductsModel
import com.example.sportsfat.presentation.adapters.products.listener.ProductsListener

class ProductsAdapter(
    private val productsListener: ProductsListener
) : RecyclerView.Adapter<ProductsViewHolder>() {

    private var listProducts = mutableListOf<ProductsModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<ProductsModel>) {
        this.listProducts.clear()
        this.listProducts = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val viewBinding =
            ListProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(listProducts[position])
    }

    override fun getItemCount(): Int {
        return listProducts.size
    }
}
