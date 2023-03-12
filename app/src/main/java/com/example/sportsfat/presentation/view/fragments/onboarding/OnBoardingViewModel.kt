package com.example.sportsfat.presentation.view.fragments.onboarding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsfat.R
import com.example.sportsfat.domain.model.UserModel
import com.example.sportsfat.domain.model.workout.TrainingDayModel
import com.example.sportsfat.domain.user.UserInteractor
import com.example.sportsfat.domain.workouts.WorkoutsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val userInteractor: UserInteractor, private val workoutsInteractor: WorkoutsInteractor
) : ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _errorHeight = MutableLiveData<Int>()
    val errorHeight: LiveData<Int> = _errorHeight

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _userData = MutableLiveData<UserModel>()
    val userData: LiveData<UserModel> = _userData

    private val _trainingDay = MutableLiveData<TrainingDayModel>()
    val trainingDay: LiveData<TrainingDayModel> = _trainingDay

    fun saveTrainingDay(trainingDayModel: TrainingDayModel){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    workoutsInteractor.saveTrainingDay(trainingDayModel)
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "saveUserDateNew")
            }
        }
    }

    var bmi: Double = 0.0

    fun calculateBMI(height: Double, weight: Int) {
        if (height == 0.0) {
            _errorHeight.value = R.string.HeightCannotBeZero
        }
        bmi = weight / (height * height)
    }

    fun saveUserDate(userModel: UserModel) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    userInteractor.saveUserData(userModel)
                    _nav.value = R.navigation.main_graph
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
                Log.w("exception", "saveUserDate")
            }
        }
    }

        fun appBackgroundSelection(background: Int) {
            val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
                Log.w("exceptionHandler called", exception.toString())
            }
            viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
                try {
                    launch {
                        userInteractor.appBackgroundSelection(background)
                    }
                } catch (e: Exception) {
                    _error.value = e.message.toString()
                    Log.w("exception", "appBackgroundSelection")
                }
            }
        }
    }
