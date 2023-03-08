package com.example.sportsfat.presentation.view.fragments.internet

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportsfat.R
import com.example.sportsfat.utils.InternetConnection
import javax.inject.Inject

class NoInternetViewModel @Inject constructor(
    private val internetConnection: InternetConnection
) : ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    @RequiresApi(Build.VERSION_CODES.M)
    fun openUser() {
        val internet = internetConnection.isOnline()
        if (internet) {
            _nav.value = R.id.action_noInternetFragment_to_userFragment
        }
    }

    fun finishPerformed() {
        _nav.value = null
    }
}