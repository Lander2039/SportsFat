package com.example.sportsfat.presentation.view.fragments.articles

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportsfat.R
import com.example.sportsfat.domain.articles.ArticlesInteractor
import com.example.sportsfat.utils.InternetConnection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articlesInteractor: ArticlesInteractor,
    private val internetConnection: InternetConnection
) :
    ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    val items = flow { emit(articlesInteractor.showData()) }

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    @RequiresApi(Build.VERSION_CODES.M)
    suspend fun getDataArticles() {
        val internet = internetConnection.isOnline()
        if (internet) {
            articlesInteractor.getData()
        } else {
            _nav.value = R.id.action_articlesFragment_to_noInternetFragment
        }
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