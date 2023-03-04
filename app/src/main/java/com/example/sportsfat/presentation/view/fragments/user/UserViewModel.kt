package com.example.sportsfat.presentation.view.fragments.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportsfat.R
import com.example.sportsfat.domain.articles.ArticlesInteractor
import com.example.sportsfat.domain.user.UserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val articlesInteractor: ArticlesInteractor,
    private val userInteractor: UserInteractor
) :
    ViewModel() {

    val items = flow { emit(articlesInteractor.showData()) }

    val itemsUserData = flow { emit(userInteractor.showUserData()) }

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    suspend fun getDataArticles() {
        articlesInteractor.getData()
    }

    fun elementClicked(articlesName: String, imageArticles: String, articlesText: String) {
        _bundle.value = NavigateWithBundle(
            articlesName,
            imageArticles,
            articlesText,
            destinationId = R.id.action_userFragment_to_detailsArticlesFragment
        )
    }

    fun userNavigated() {
        _bundle.value = null
    }

    fun openMonday() {
        _nav.value = R.id.action_userFragment_to_userDataFragment
    }

    fun finishPerformed() {
        _nav.value = null
    }
}

data class NavigateWithBundle(
    val articlesName: String,
    val imageArticles: String,
    val articlesText: String,
    val destinationId: Int
)