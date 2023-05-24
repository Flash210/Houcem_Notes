package com.example.data

import com.example.model.Note

class NoteDataSource{


fun loadNotes():List<Note>
{
    return listOf(
        Note(title = "A", description = "xx"),
        Note(title = "B", description = "xx"),
        Note(title = "C", description = "xx"),
        Note(title = "D", description = "xx"),
        Note(title = "E", description = "xx"),
        Note(title = "F", description = "xx"),
        Note(title = "G", description = "xx"),

        )
}

}