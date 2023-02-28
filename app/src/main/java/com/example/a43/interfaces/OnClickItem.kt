package com.example.a43.interfaces

import com.example.a43.model.NoteModel

interface OnClickItem {
    fun onLongClick(noteModel: NoteModel)
}