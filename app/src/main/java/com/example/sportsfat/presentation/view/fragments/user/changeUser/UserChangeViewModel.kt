package com.example.sportsfat.presentation.view.fragments.user.changeUser

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
class UserChangeViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) : ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _userData = MutableLiveData<UserModel>()
    val userData: LiveData<UserModel> = _userData

    fun saveUserWeightStart(
        id: Int,
        weightStart: Int
    ) {
        viewModelScope.launch {
            try {
                userInteractor.saveUserDataToday(
                    id, weightStart
                )
            } catch (e: Exception) {
                _error.value = e.message.toString()
            }
        }
        _nav.value = R.id.action_userChangeFragment_to_userFragment
    }
}