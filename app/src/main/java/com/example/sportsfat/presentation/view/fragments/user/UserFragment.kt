package com.example.sportsfat.presentation.view.fragments.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsfat.databinding.FragmentUserBinding
import com.example.sportsfat.presentation.adapters.articles.UserArticlesAdapter
import com.example.sportsfat.presentation.adapters.articles.listener.ArticlesListener
import com.example.sportsfat.utils.BundleConstants
import com.example.sportsfat.utils.NavHelper.navigate
import com.example.sportsfat.utils.NavHelper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch

@AndroidEntryPoint
class UserFragment : Fragment(), ArticlesListener {

    private val viewModel: UserViewModel by viewModels()
    private var _viewBinding: FragmentUserBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var userArticlesAdapter: UserArticlesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentUserBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userDataShow()

        viewModel.userData.observe(viewLifecycleOwner) {
            viewBinding.tvUserName.text = it.name
            viewBinding.tvUserWeightBefore.text = it.weightStart.toString()
            viewBinding.tvUserWeightBefore2.text = it.weightToday.toString()
            viewBinding.tvMyResultAfter.text = (it.weightStart - it.weightToday).toString()
        }
        userArticlesAdapter = UserArticlesAdapter(this)

        viewBinding.resArticlesUser.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewBinding.resArticlesUser.adapter = userArticlesAdapter

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.items.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }.collect { flowList ->
                flowList.collect { list ->
                    userArticlesAdapter.submitList(list)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.getDataArticles()
        }

        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val bundle = Bundle()
                bundle.putString(BundleConstants.NAME_ARTICLES, navBundle.articlesName)
                bundle.putString(BundleConstants.IMAGE_ARTICLES, navBundle.imageArticles)
                bundle.putString(BundleConstants.TEXT_ARTICLES, navBundle.articlesText)

                navigateWithBundle(
                    navBundle.destinationId, bundle
                )
                viewModel.userNavigated()
            }
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                navigate(it)
            }
        }
        viewBinding.iwEditUser.setOnClickListener {
            viewModel.openUserDate()
            viewModel.finishPerformed()
        }

        viewBinding.iwChangeUser.setOnClickListener {
            viewModel.openUserChange()
            viewModel.finishPerformed()
        }
    }

    override fun onElementSelected(articlesName: String, image: String, articlesText: String) {
        viewModel.elementClicked(articlesName, image, articlesText)
    }
}