package com.example.sportsfat.domain.model

import com.google.android.material.textfield.TextInputEditText

data class UserModel(
    val name: String,
    val age: Int,
    val height: Double,
    val weightStart: Int,
    val weightToday: Int,
    val image: Int,
    val activityFactor: Double,
    val bmi: Int,
    val resultWeight: Int
)
