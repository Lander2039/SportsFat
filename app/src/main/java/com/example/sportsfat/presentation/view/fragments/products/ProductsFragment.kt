package com.example.sportsfat.presentation.view.fragments.products

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsfat.R
import com.example.sportsfat.databinding.FragmentProductsBinding
import com.example.sportsfat.presentation.adapters.products.ProductsAdapter
import com.example.sportsfat.presentation.adapters.products.listener.ProductsListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch

@AndroidEntryPoint
class ProductsFragment : Fragment(), ProductsListener {

    private lateinit var productsAdapter: ProductsAdapter
    private val viewModel: ProductsViewModel by viewModels()
    private var _viewBinding: FragmentProductsBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentProductsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDataProducts()

        productsAdapter = ProductsAdapter(this)

        viewBinding.resWorkout.layoutManager = LinearLayoutManager(context)
        viewBinding.resWorkout.adapter = productsAdapter

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.products.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }.collect { flowList ->
                flowList.collect { list ->
                    productsAdapter.submitList(list)

                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
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

        viewModel.product.observe(viewLifecycleOwner) {
            viewBinding.tvNameProduct.text = it.name
            viewBinding.tvCaloriesProduct.text =
                getString(R.string.Calories) + it.calories.toString()
            viewBinding.tvSquirrelsProduct.text =
                getString(R.string.Squirrels) + it.squirrels.toString()
            viewBinding.tvFatsProduct.text = getString(R.string.Fats) + it.fats.toString()
            viewBinding.tvCarbohydratesProduct.text =
                getString(R.string.Carbohydrates) + it.carbohydrates.toString()
        }
        viewBinding.btnShow.setOnClickListener {
            if (viewBinding.resWorkout.visibility == View.VISIBLE) {
                viewBinding.resWorkout.visibility = View.INVISIBLE
            } else {
                viewBinding.resWorkout.visibility = View.VISIBLE
            }
        }
    }
}