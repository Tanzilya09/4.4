package com.example.a43.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.a43.model.NoteModel

@Dao

interface NotDao {

    @Query("SELECT * FROM Note")
    fun getAll(): LiveData<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(noteModel: NoteModel)

    @Delete
    fun delete(model: NoteModel)
}