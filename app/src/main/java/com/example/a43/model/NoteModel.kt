package com.example.a43.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteModel(
    val line: String,
    val number: String,
    val time: String,
    val color: String,

    ):java.io.Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
