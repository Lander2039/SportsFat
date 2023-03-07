package com.example.sportsfat.data.sharedPreferemces

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    fun appBackgroundSelection(background: Int) {
        sharedPreferences.edit().putInt(BACKGROUND, background).apply()
    }

    fun checkUserExists(): Boolean {
        val background = sharedPreferences.getInt(BACKGROUND, 0)
        return (background != 0)
    }

    companion object {
        private const val BACKGROUND = "BACKGROUND"
    }
}