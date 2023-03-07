package com.example.sportsfat.domain.user

import com.example.sportsfat.domain.model.UserModel

interface UserRepository {

    suspend fun saveUserData(userModel: UserModel)
    suspend fun showUserData(): UserModel
    suspend fun saveUserDataStart(
        id: Int,
        name: String,
        age: Int,
        height: Double,
        weightStart: Int,
        activityFactor: Double,
        bmi: Int
    )

    suspend fun saveUserDataToday(id: Int, weightToday: Int)

    suspend fun appBackgroundSelection(background: Int)

    suspend fun doesAppBackgroundSelection(): Boolean

}