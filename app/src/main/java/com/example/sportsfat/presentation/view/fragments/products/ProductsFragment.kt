package com.example.sportsfat.presentation.view.fragments.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsfat.databinding.FragmentProductsBinding
import com.example.sportsfat.presentation.adapters.products.ProductsAdapter
import com.example.sportsfat.presentation.adapters.products.listener.ProductsListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch

@AndroidEntryPoint
class ProductsFragment : Fragment(), ProductsListener {

    private val viewModel: ProductsViewModel by viewModels()

    private var _viewBinding: FragmentProductsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentProductsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productsAdapter= ProductsAdapter(this)
        viewBinding.resProducts.layoutManager = LinearLayoutManager(context)
        viewBinding.resProducts.adapter = productsAdapter

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.items.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }.collect { flowList ->
                flowList.collect { list ->
                    productsAdapter.submitList(list)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.getDataProducts()
        }

        viewBinding.searchProducts.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                viewModel.findProduct(p0 ?: "")
                return false
            }
        })

        viewModel.product.observe(viewLifecycleOwner){
            viewBinding.tvNameProduct.text = it.name
            viewBinding.tvCaloriesProduct.text= it.calories.toString()
            viewBinding.tvSquirrelsProduct.text = it.squirrels.toString()
            viewBinding.tvFatsProduct.text = it.fats.toString()
            viewBinding.tvCarbohydratesProduct.text = it.carbohydrates.toString()
        }
    }
}