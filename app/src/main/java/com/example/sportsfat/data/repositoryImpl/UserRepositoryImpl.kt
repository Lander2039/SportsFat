package com.example.sportsfat.data.repositoryImpl

import com.example.sportsfat.data.database.dao.DAO
import com.example.sportsfat.data.database.entity.UserEntity
import com.example.sportsfat.domain.model.UserModel
import com.example.sportsfat.domain.user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val DAO: DAO
) : UserRepository {

    override suspend fun saveUserData(userModel: UserModel) {
        return withContext(Dispatchers.IO) {
            DAO.insertUserEntity(
                UserEntity(
                    Random().nextInt(),
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

    override suspend fun saveUserDataStart(name: String, age: Int, height: Double, weightStart: Int, activityFactor: Double,bmi: Int) {
        return withContext(Dispatchers.IO) {
            DAO.updateUserDate(name,age,height,weightStart,activityFactor,bmi)
        }
    }

    override suspend fun saveUserDataToday(name: String, weightToday: Int) {
        return withContext(Dispatchers.IO) {
            DAO.updateUserDateToday(name,weightToday)
        }
    }


}