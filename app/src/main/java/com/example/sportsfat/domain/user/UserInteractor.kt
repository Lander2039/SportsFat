package com.example.sportsfat.domain.user

import com.example.sportsfat.domain.model.UserModel
import javax.inject.Inject

class UserInteractor @Inject constructor(private val userRepository: UserRepository) {

    suspend fun saveUserData(userModel: UserModel) {
        return userRepository.saveUserData(userModel)
    }

    suspend fun showUserData(): UserModel {
        return userRepository.showUserData()
    }

    suspend fun saveUserDataStart(
        id: Int,
        name: String,
        age: Int,
        height: Double,
        weightStart: Int,
        activityFactor: Double,
        bmi: Int
    ) {
        return userRepository.saveUserDataStart(
            id,
            name,
            age,
            height,
            weightStart,
            activityFactor,
            bmi
        )
    }

    suspend fun saveUserDataToday(id: Int, weightToday: Int) {
        return userRepository.saveUserDataToday(id, weightToday)
    }
    suspend fun appBackgroundSelection(background:Int) {
        return userRepository.appBackgroundSelection(background)
    }
    suspend fun checkAppBackgroundSelection(): Boolean{
        return userRepository.doesAppBackgroundSelection()
    }

}