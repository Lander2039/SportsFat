package com.example.sportsfat.presentation.view.fragments.workouts.trainingDay.monday.detailWorkouts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsfat.R
import com.example.sportsfat.domain.workouts.WorkoutsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsWorkoutViewModel @Inject constructor(private val workoutsInteractor: WorkoutsInteractor) :
    ViewModel() {

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    fun addApproaches(name: String, approaches: String, repetitions: String, weight: String) {
        viewModelScope.launch {
            workoutsInteractor.saveApproaches(name, approaches, repetitions, weight)
            _msg.value = R.string.Saved
        }
    }
}