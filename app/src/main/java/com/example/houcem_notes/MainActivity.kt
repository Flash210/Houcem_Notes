package com.example.houcem_notes

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.collectAsState

import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.houcem_notes.ui.theme.Houcem_NotesTheme
import com.example.screen.NoteScreen
import com.example.screen.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalComposeApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Houcem_NotesTheme {


             val noteViewModel= viewModel<NoteViewModel>()
             
             NotesApp(noteViewModel = noteViewModel)




            }
        }
    }
}



@Composable
@ExperimentalComposeApi

fun NotesApp(
    noteViewModel: NoteViewModel){
    val notesList=noteViewModel.notesList.collectAsState().value

    NoteScreen(notes = notesList,
        onAddNote =
        {
            noteViewModel.addNote(it)
        },
        onRemoveNote ={
            noteViewModel.removeNote(it)
        } )

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Houcem_NotesTheme {
    }
}