package com.example.sportsfat.domain.user

import com.example.sportsfat.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun saveUserData(userModel: UserModel)
    suspend fun showUserData(): UserModel
    suspend fun saveUserDataStart(
        name: String,
        age: Int,
        height: Double,
        weightStart: Int,
        activityFactor: Double,
        bmi: Int
    )

    suspend fun saveUserDataToday(name: String, weightToday: Int)

}