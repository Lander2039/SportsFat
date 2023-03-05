package com.example.sportsfat.presentation.view.fragments.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportsfat.R
import com.example.sportsfat.domain.model.UserModel
import com.example.sportsfat.domain.user.UserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) : ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _errorHeight = MutableLiveData<Int>()
    val errorHeight: LiveData<Int> = _errorHeight

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _userData = MutableLiveData<UserModel>()
    val userData: LiveData<UserModel> = _userData

    var bmi: Double = 0.0

    fun calculateBMI(height: Double, weight: Int) {
        if (height == 0.0) {
            _errorHeight.value = R.string.HeightCannotBeZero
        }
        bmi = weight / (height * height)
    }

    fun saveUserDate(userModel: UserModel) {
        viewModelScope.launch {
            try {
                userInteractor.saveUserData(userModel)
            } catch (e: Exception) {
                _error.value = e.message.toString()
            }
        }
        _nav.value = R.navigation.main_graph
    }

    fun appBackgroundSelection(background:Int){
        viewModelScope.launch {
            try {
                userInteractor.appBackgroundSelection(background)
            } catch (e: Exception) {
                _error.value = e.message.toString()
            }
        }
    }
}