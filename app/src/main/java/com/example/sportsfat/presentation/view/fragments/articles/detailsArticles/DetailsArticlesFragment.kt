package com.example.sportsfat.presentation.view.fragments.articles.detailsArticles

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sportsfat.R
import com.example.sportsfat.databinding.FragmentArticlesBinding
import com.example.sportsfat.databinding.FragmentDetailsArticlesBinding
import com.example.sportsfat.utils.BundleConstants
import com.squareup.picasso.Picasso
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

        val bundle = arguments
        bundle?.let { safeBundle ->
            val nameArticles = safeBundle.getString(BundleConstants.NAME_ARTICLES)
            val image = safeBundle.getString(BundleConstants.IMAGE_ARTICLES)
            val textArticles = safeBundle.getString(BundleConstants.TEXT_ARTICLES)

            viewBinding.tvNameArticles.text = nameArticles
            Picasso.get().load(Uri.parse(image)).into(viewBinding.ivImageArticles)
            viewBinding.tvTextArticles.text = textArticles
        }

    }
}