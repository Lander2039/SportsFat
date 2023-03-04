package com.example.sportsfat.domain.user

import com.example.sportsfat.domain.model.UserModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserInteractor @Inject constructor(private val userRepository: UserRepository) {

    suspend fun saveUserData(userModel: UserModel){
        return userRepository.saveUserData(userModel)
    }

    suspend fun showUserData(): UserModel{
        return userRepository.showUserData()
    }
    suspend fun saveUserDataStart(name: String, age: Int, height: Double, weightStart: Int, activityFactor: Double, bmi: Int){
        return userRepository.saveUserDataStart(name,age, height, weightStart, activityFactor, bmi)
    }

    suspend fun saveUserDataToday(name: String, weightToday: Int){
        return userRepository.saveUserDataToday(name, weightToday)
    }
}