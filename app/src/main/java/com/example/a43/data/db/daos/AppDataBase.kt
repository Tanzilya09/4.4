package com.example.a43.data.db.daos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a43.model.NoteModel

@Database(entities = [NoteModel::class], version = 3)

abstract class AppDataBase : RoomDatabase() {
    abstract fun noteDao(): NotDao
}
