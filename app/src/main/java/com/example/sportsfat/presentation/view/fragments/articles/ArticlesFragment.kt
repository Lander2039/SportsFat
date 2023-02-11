package com.example.sportsfat.presentation.view.fragments.articles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sportsfat.R
import com.example.sportsfat.databinding.FragmentArticlesBinding
import com.example.sportsfat.presentation.adapters.articles.ArticlesAdapter
import com.example.sportsfat.presentation.adapters.articles.listener.ArticlesListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticlesFragment : Fragment(), ArticlesListener {

    private val viewModel: ArticlesViewModel by viewModels()

    private lateinit var articlesAdapter: ArticlesAdapter

    private var _viewBinding: FragmentArticlesBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentArticlesBinding.inflate(inflater,container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articlesAdapter = ArticlesAdapter(this)

    }

    override fun onElementSelected(nameArticles: String, imageArticles: String) {
        TODO("Not yet implemented")
    }
}