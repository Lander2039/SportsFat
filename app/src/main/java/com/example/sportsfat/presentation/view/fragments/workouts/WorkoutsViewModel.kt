package com.example.sportsfat.presentation.view.fragments.workouts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportsfat.R
import dagger.hilt.android.lifecycle.HiltViewModel

class WorkoutsViewModel :
    ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    fun openMonday() {
        _nav.value = R.id.action_workoutsFragment_to_mondayFragment
    }

    fun finishPerformed() {
        _nav.value = null
    }
}