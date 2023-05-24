package com.example.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.data.NoteDataSource
import com.example.model.Note

class NoteViewModel:ViewModel() {

    var notesList= mutableStateListOf<Note>()


init {
    notesList.addAll(NoteDataSource().loadNotes())
}




    fun addNote(note: Note)
    {
        notesList.add(note)
    }

fun removeNote(note: Note)
{
    notesList.remove(note)
}


    fun getAllNotes():List<Note>
    {
        return notesList
    }

}