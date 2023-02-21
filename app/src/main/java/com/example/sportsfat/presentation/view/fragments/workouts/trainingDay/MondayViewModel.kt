package com.example.sportsfat.presentation.view.fragments.workouts.trainingDay

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
class MondayViewModel @Inject constructor(private val workoutsInteractor: WorkoutsInteractor) :
    ViewModel() {

    val items = flow { emit(workoutsInteractor.getMondayWorkouts()) }

//    private val _bundle = MutableLiveData<NavigateWithBundle?>()
//    val bundle: LiveData<NavigateWithBundle?> = _bundle

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    fun openListWorkouts(){
        _nav.value = R.id.action_mondayFragment_to_listWorkoutsFragment
    }

    fun finishPerformed(){
        _nav.value = null
    }

    fun deleteMondayWorkout(name: String){
        viewModelScope.launch {
            workoutsInteractor.deleteWorkoutByName(name)
            _msg.value = R.string.workoutDelete
        }
    }

//    fun elementClicked(articlesName: String, imageArticles: String, articlesText: String) {
//        _bundle.value = NavigateWithBundle(
//            articlesName,
//            imageArticles,
//            articlesText,
//            destinationId = R.id.action_articlesFragment_to_detailsArticlesFragment
//        )
//    }
//
//    fun userNavigated() {
//        _bundle.value = null
//    }
}
