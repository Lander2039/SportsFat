package com.example.sportsfat.presentation.view.fragments.articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportsfat.R
import com.example.sportsfat.domain.articles.ArticlesInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(private val articlesInteractor: ArticlesInteractor) :
    ViewModel() {

    val items = flow { emit(articlesInteractor.showData()) }

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    suspend fun getDataArticles() {
        articlesInteractor.getData()
    }

    fun elementClicked(articlesName: String, imageArticles: String, articlesText: String) {
        _bundle.value = NavigateWithBundle(
            articlesName,
            imageArticles,
            articlesText,
            destinationId = R.id.action_articlesFragment_to_detailsArticlesFragment
        )
    }

    fun userNavigated() {
        _bundle.value = null
    }
}

data class NavigateWithBundle(
    val articlesName: String,
    val imageArticles: String,
    val articlesText: String,
    val destinationId: Int
)