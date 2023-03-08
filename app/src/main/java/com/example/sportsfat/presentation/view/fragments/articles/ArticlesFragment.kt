package com.example.sportsfat.presentation.view.fragments.articles

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsfat.databinding.FragmentArticlesBinding
import com.example.sportsfat.presentation.adapters.articles.ArticlesAdapter
import com.example.sportsfat.presentation.adapters.articles.listener.ArticlesListener
import com.example.sportsfat.utils.BundleConstants.IMAGE_ARTICLES
import com.example.sportsfat.utils.BundleConstants.NAME_ARTICLES
import com.example.sportsfat.utils.BundleConstants.TEXT_ARTICLES
import com.example.sportsfat.utils.NavHelper.navigate
import com.example.sportsfat.utils.NavHelper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch

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
        _viewBinding = FragmentArticlesBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articlesAdapter = ArticlesAdapter(this)

        viewBinding.resArticles.layoutManager = LinearLayoutManager(context)
        viewBinding.resArticles.adapter = articlesAdapter

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.items.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }.collect { flowList ->
                flowList.collect { list ->
                    articlesAdapter.submitList(list)
                }
            }
        }
        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                navigate(it)
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                viewModel.getDataArticles()
            }
        }

        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val bundle = Bundle()
                bundle.putString(NAME_ARTICLES, navBundle.articlesName)
                bundle.putString(IMAGE_ARTICLES, navBundle.imageArticles)
                bundle.putString(TEXT_ARTICLES, navBundle.articlesText)

                navigateWithBundle(
                    navBundle.destinationId, bundle
                )
                viewModel.userNavigated()
            }
        }
    }

    override fun onElementSelected(articlesName: String, image: String, articlesText: String) {
        viewModel.elementClicked(articlesName, image, articlesText)
    }
}