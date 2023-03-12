package com.example.sportsfat.presentation.view.activity

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDestination
import com.example.sportsfat.R
import com.example.sportsfat.domain.user.UserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userInteractor: UserInteractor) : ViewModel() {

    private val _nav = MutableLiveData<Int>()
    val nav: LiveData<Int> = _nav

    private val _visibility = MutableLiveData<Int>()
    val visibility: LiveData<Int> = _visibility

    private val _msg = MutableLiveData<String?>()
    val msg: LiveData<String?> = _msg

    fun checkUserExists() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    val doesUserExist: Boolean = userInteractor.checkAppBackgroundSelection()
                    _nav.value = when (doesUserExist) {
                        true -> R.navigation.main_graph
                        false -> R.navigation.start_graph
                    }
                }

            } catch (e: Exception) {
                _msg.value = e.message.toString()
                Log.w("exception", "checkUserExists")
            }
        }
    }

    fun destinationChanged(destination: NavDestination) {
        if (destination.id == R.id.onBoardingFragment || destination.id == R.id.noInternetFragment) {
            _visibility.value = View.GONE
        } else {
            _visibility.value = View.VISIBLE
        }
    }
}