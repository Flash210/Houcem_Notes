package com.example.screen

import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Note
import com.example.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) :ViewModel() {

  //  var notesList= mutableStateListOf<Note>()

    private val _noteList= MutableStateFlow<List<Note>>(emptyList())

    val notesList=_noteList.asStateFlow()
init {

    viewModelScope.launch ( Dispatchers.IO ){
        repository.getAllNotes().distinctUntilChanged()
            .collect{
                listOfNotes->

                if (listOfNotes.isEmpty())
                {
                     Log.d("Empty","EMpty list ")
                }else
                {
                   _noteList.value=listOfNotes
                }

            }

    }

   // notesList.addAll(NoteDataSource().loadNotes())
}




    fun addNote(note: Note)=viewModelScope.launch { repository.addNote(note = note) }

 fun removeNote(note: Note)=viewModelScope.launch { repository.deleteNote(note=note) }

     fun updateNote(note: Note)=viewModelScope.launch { repository.updateNote(note=note) }


    fun getAllNotes(): Job =viewModelScope.launch { repository.getAllNotes() }

}