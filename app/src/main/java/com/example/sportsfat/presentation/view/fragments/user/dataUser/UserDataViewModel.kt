package com.example.sportsfat.presentation.view.fragments.user.dataUser

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
class UserDataViewModel @Inject constructor(private val userInteractor: UserInteractor) :
    ViewModel() {

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

    fun saveUserDateNew(
        id: Int,
        name: String,
        age: Int,
        height: Double,
        weightStart: Int,
        activityFactor: Double,
        bmi: Int
    ) {
        viewModelScope.launch {
            try {
                userInteractor.saveUserDataStart(
                    id,
                    name,
                    age,
                    height,
                    weightStart,
                    activityFactor,
                    bmi
                )
            } catch (e: Exception) {
                _error.value = e.message.toString()
            }
        }
        _nav.value = R.id.action_userDataFragment_to_userFragment
    }

    fun userDataShow() {
        viewModelScope.launch {
            try {
                _userData.value = userInteractor.showUserData()
            } catch (e: Exception) {
                _error.value = e.message.toString()
            }
        }
    }

}