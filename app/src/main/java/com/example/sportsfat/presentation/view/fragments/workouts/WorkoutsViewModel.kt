package com.example.sportsfat.presentation.view.fragments.workouts

import androidx.lifecycle.ViewModel
import com.example.sportsfat.domain.workouts.WorkoutsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkoutsViewModel @Inject constructor(private val workoutsInteractor: WorkoutsInteractor) :
    ViewModel() {
}