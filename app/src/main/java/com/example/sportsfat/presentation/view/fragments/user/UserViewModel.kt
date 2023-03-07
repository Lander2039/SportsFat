package com.example.sportsfat.presentation.view.fragments.user

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsfat.R
import com.example.sportsfat.domain.articles.ArticlesInteractor
import com.example.sportsfat.domain.model.UserModel
import com.example.sportsfat.domain.user.UserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val articlesInteractor: ArticlesInteractor,
    private val userInteractor: UserInteractor
) :
    ViewModel() {

    val items = flow { emit(articlesInteractor.showData()) }

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _userData = MutableLiveData<UserModel>()
    val userData: LiveData<UserModel> = _userData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

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

    fun openUserDate() {
        _nav.value = R.id.action_userFragment_to_userDataFragment
    }

    fun openUserChange() {
        _nav.value = R.id.action_userFragment_to_userChangeFragment
    }

    fun finishPerformed() {
        _nav.value = null
    }

    fun userDataShow() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    _userData.value = userInteractor.showUserData()
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "userDataShow")
            }
        }
    }
}

data class NavigateWithBundle(
    val articlesName: String,
    val imageArticles: String,
    val articlesText: String,
    val destinationId: Int
)