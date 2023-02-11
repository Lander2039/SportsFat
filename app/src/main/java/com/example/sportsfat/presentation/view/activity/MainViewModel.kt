package com.example.sportsfat.presentation.view.activity

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDestination
import com.example.sportsfat.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _nav = MutableLiveData<Int>()
    val nav: LiveData<Int> = _nav

    private val _visibility = MutableLiveData<Int>()
    val visibility: LiveData<Int> = _visibility

    fun checkUserExists() {
        viewModelScope.launch {
            _nav.value = R.navigation.main_graph
        }
    }

    fun destinationChanged(destination: NavDestination) {
        if (destination.id == R.id.onBoardingFragment) {
            _visibility.value = View.GONE
        } else {
            _visibility.value = View.VISIBLE
        }
    }
}