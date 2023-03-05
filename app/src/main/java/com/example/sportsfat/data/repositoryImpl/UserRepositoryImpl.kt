package com.example.sportsfat.data.repositoryImpl

import com.example.sportsfat.data.database.dao.DAO
import com.example.sportsfat.data.database.entity.UserEntity
import com.example.sportsfat.data.sharedPreferemces.SharedPreferencesHelper
import com.example.sportsfat.domain.model.UserModel
import com.example.sportsfat.domain.user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val DAO: DAO,
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : UserRepository {

    override suspend fun saveUserData(userModel: UserModel) {
        return withContext(Dispatchers.IO) {
            DAO.insertUserEntity(
                UserEntity(
                    userModel.id,
                    userModel.name,
                    userModel.age,
                    userModel.height,
                    userModel.weightStart,
                    userModel.weightToday,
                    userModel.image,
                    userModel.activityFactor,
                    userModel.bmi,
                    userModel.resultWeight
                )
            )
        }
    }

    override suspend fun showUserData(): UserModel {
        return withContext(Dispatchers.IO) {
            val userEntity = DAO.getUserEntities()
            UserModel(
                userEntity.id,
                userEntity.name,
                userEntity.age,
                userEntity.height,
                userEntity.weightStart,
                userEntity.weightToday,
                userEntity.image,
                userEntity.activityFactor,
                userEntity.bmi,
                userEntity.resultWeight
            )
        }
    }

    override suspend fun saveUserDataStart(
        id: Int,
        name: String,
        age: Int,
        height: Double,
        weightStart: Int,
        activityFactor: Double,
        bmi: Int
    ) {
        return withContext(Dispatchers.IO) {
            DAO.updateUserDate(id, name, age, height, weightStart, activityFactor, bmi)
        }
    }

    override suspend fun saveUserDataToday(id: Int, weightToday: Int) {
        return withContext(Dispatchers.IO) {
            DAO.updateUserDateToday(id, weightToday)
        }
    }

    override suspend fun appBackgroundSelection(background: Int) {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.appBackgroundSelection(background)
        }
    }

    override suspend fun doesAppBackgroundSelection(): Boolean {
        return withContext(Dispatchers.IO) {
            sharedPreferencesHelper.checkUserExists()
        }
    }
}