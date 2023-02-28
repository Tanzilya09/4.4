package com.example.a43

import android.app.Application
import androidx.room.Room
import com.example.a43.data.db.daos.AppDataBase
import com.example.a43.utils.PreferenceHelper

class App: Application() {
    companion object{
        val preferenceHelper = PreferenceHelper()
        var appDataBase: AppDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        initPref()
        getInstance()
    }

    private fun initPref(){
    preferenceHelper.unit(this)
    }
    fun getInstance(): AppDataBase? {
        if (appDataBase == null){
            appDataBase = applicationContext?.let {
                Room.databaseBuilder(
                    it,
                    AppDataBase:: class.java,
                    "note.database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
        }
    }
        return appDataBase
    }
}