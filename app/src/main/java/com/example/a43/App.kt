package com.example.a43

import android.app.Application
import com.example.a43.utils.PreferenceHelper

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        helper()
    }

    private fun helper() {
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(this)
    }
}