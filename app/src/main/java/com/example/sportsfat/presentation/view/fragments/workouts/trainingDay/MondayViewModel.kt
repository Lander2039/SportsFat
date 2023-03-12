package com.example.sportsfat.presentation.view.fragments.workouts.trainingDay

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
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MondayViewModel @Inject constructor(private val workoutsInteractor: WorkoutsInteractor) :
    ViewModel() {

    val items = flow { emit(workoutsInteractor.getMondayWorkouts()) }

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _name = MutableLiveData<Int?>()
    val name: LiveData<Int?> = _name

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _trainingDay = MutableLiveData<TrainingDayModel>()
    val trainingDay: LiveData<TrainingDayModel> = _trainingDay

    fun openListWorkouts() {
        _nav.value = R.id.action_mondayFragment_to_listWorkoutsFragment
    }

    fun finishPerformed() {
        _nav.value = null
    }

    fun deleteMondayWorkout(name: String) {
        viewModelScope.launch {
            workoutsInteractor.deleteWorkoutByName(name)
            _msg.value = R.string.workoutDelete
        }
    }

    fun elementClicked(
        name: String,
        description: String,
        implementationOptions: String,
        executionTechnique: String,
        image: Int,
        approaches: String,
        repetitions: String,
        nameWorkoutsDay: String
    ) {
        _bundle.value = NavigateWithBundle(
            name,
            description,
            implementationOptions,
            executionTechnique,
            image,
            approaches,
            repetitions,
            nameWorkoutsDay,
            destinationId = R.id.action_mondayFragment_to_detailsWorkoutFragment,
        )
    }

    fun userNavigated() {
        _bundle.value = null
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

data class NavigateWithBundle(
    val name: String,
    val description: String,
    val implementationOptions: String,
    val executionTechnique: String,
    val image: Int,
    val approaches: String,
    val repetitions: String,
    val nameWorkoutsDay: String,
    val destinationId: Int,
)
