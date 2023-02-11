package com.example.sportsfat.presentation.view.fragments.articles.detailsArticles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sportsfat.R
import com.example.sportsfat.databinding.FragmentArticlesBinding
import com.example.sportsfat.databinding.FragmentDetailsArticlesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsArticlesFragment : Fragment() {

    private var _viewBinding: FragmentDetailsArticlesBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: DetailsArticlesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailsArticlesBinding.inflate(inflater,container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}