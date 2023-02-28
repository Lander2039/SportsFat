package com.example.sportsfat.presentation.view.fragments.workouts.listOfWorkouts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsfat.R
import com.example.sportsfat.domain.workouts.WorkoutsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListWorkoutsViewModel  @Inject constructor(private val workoutsInteractor: WorkoutsInteractor) :
    ViewModel() {

    val items = flow { emit(workoutsInteractor.showData()) }

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _arm = MutableLiveData<Int?>()
    val arm: LiveData<Int?> = _arm

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    suspend fun getDataArticles(){
        workoutsInteractor.getData()
    }

    fun onAddClicked(name: String, isFavorite: Boolean) {
        viewModelScope.launch {
            workoutsInteractor.onAddMondayWorkouts(name, isFavorite)
            _msg.value = R.string.WorkoutAdd
        }
    }

    fun elementClicked(name: String, description: String, implementationOptions: String, executionTechnique: String,image: Int) {
        _bundle.value = NavigateWithBundle(
            name,
            description,
            implementationOptions,
            executionTechnique,
            image,
            destinationId = R.id.action_listWorkoutsFragment_to_detailsWorkoutFragment,
        )
    }

    fun userNavigated() {
        _bundle.value = null
    }

    data class NavigateWithBundle(
        val name: String,
        val description: String,
        val implementationOptions: String,
        val executionTechnique: String,
        val image: Int,
        val destinationId: Int,
    )
}
