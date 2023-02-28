package com.example.a43.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private lateinit var sharePreference: SharedPreferences

    fun unit(context: Context) {
        sharePreference = context.getSharedPreferences("setting", Context.MODE_PRIVATE)
    }

    var onSaveOnBoardState: Boolean
        set(value) = sharePreference.edit().putBoolean("yes", value).apply()
        get() = sharePreference.getBoolean("yes", true)

    var signUp:Boolean
        set(value) = sharePreference.edit().putBoolean("sign",value).apply()
        get() = sharePreference.getBoolean("sign",false)
}