package com.example.sportsfat.presentation.view.fragments.articles

import androidx.lifecycle.ViewModel
import com.example.sportsfat.domain.articles.ArticlesInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(private val articlesInteractor: ArticlesInteractor) :
    ViewModel() {


}