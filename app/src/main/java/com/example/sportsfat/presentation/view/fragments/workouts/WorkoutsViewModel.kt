package com.example.sportsfat.presentation.view.fragments.workouts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsfat.R
import com.example.sportsfat.domain.model.workout.TrainingDayModel
import com.example.sportsfat.domain.workouts.WorkoutsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutsViewModel @Inject constructor(private val workoutsInteractor: WorkoutsInteractor) :
    ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    fun openMonday() {
        _nav.value = R.id.action_workoutsFragment_to_mondayFragment
    }

    fun openNoInternet() {
        _nav.value = R.id.action_workoutsFragment_to_noInternetFragment
    }

    fun finishPerformed() {
        _nav.value = null
    }

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _trainingDay = MutableLiveData<TrainingDayModel>()
    val trainingDay: LiveData<TrainingDayModel> = _trainingDay

    fun saveTrainingDay1(
        id: Int,
        firstDay: String,
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    workoutsInteractor.saveTrainingDay1(id, firstDay)
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "saveUserDateNew")
            }
        }
    }

    fun saveTrainingDay2(
        id: Int,
        secondDay: String
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    workoutsInteractor.saveTrainingDay2(id, secondDay)
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "saveUserDateNew")
            }
        }
    }

    fun saveTrainingDay3(
        id: Int,
        theThirdDay: String
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    workoutsInteractor.saveTrainingDay3(id, theThirdDay)
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "saveUserDateNew")
            }
        }
    }

    fun saveTrainingDay4(
        id: Int,
        fourthDay: String,
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    workoutsInteractor.saveTrainingDay4(id, fourthDay)
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "saveUserDateNew")
            }
        }
    }

    fun saveTrainingDay5(
        id: Int,
        fifthDay: String
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    workoutsInteractor.saveTrainingDay5(id, fifthDay)
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "saveUserDateNew")
            }
        }
    }

    fun saveTrainingDay6(
        id: Int,
        sixthDay: String
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    workoutsInteractor.saveTrainingDay6(id, sixthDay)
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "saveUserDateNew")
            }
        }
    }

    fun saveTrainingDay7(
        id: Int,
        seventhDay: String
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    workoutsInteractor.saveTrainingDay7(id, seventhDay)
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "saveUserDateNew")
            }
        }
    }

    fun trainingDayShow() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    _trainingDay.value = workoutsInteractor.showTrainingDay()
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "userDataShow")
            }
        }
    }
}