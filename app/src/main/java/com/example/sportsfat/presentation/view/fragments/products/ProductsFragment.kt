package com.example.sportsfat.presentation.view.fragments.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sportsfat.databinding.FragmentProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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