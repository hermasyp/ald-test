package com.catnip.avengersapp.data.preference

import android.content.Context
import android.content.SharedPreferences

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class UserPreference(context: Context) {
    private var preference: SharedPreferences

    companion object {
        private const val NAME = "UserPreference"
        private const val MODE = Context.MODE_PRIVATE
        private val IS_LOGIN_PREF = Pair("IS_LOGIN", false)
        private val USERNAME_PREF = Pair("USERNAME", null)
    }

    init {
        preference = context.getSharedPreferences(NAME, MODE)
    }
    var isLoggedIn: Boolean
        get() = preference.getBoolean(IS_LOGIN_PREF.first, IS_LOGIN_PREF.second)
        set(value) = preference.edit {
            it.putBoolean(IS_LOGIN_PREF.first, value)
        }

    var username: String?
        get() = preference.getString(USERNAME_PREF.first, USERNAME_PREF.second)
        set(value) = preference.edit {
            it.putString(USERNAME_PREF.first, value)
        }
}

private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = edit()
    operation(editor)
    editor.apply()
}