package com.example.houcem_notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.NoteDataSource
import com.example.houcem_notes.ui.theme.Houcem_NotesTheme
import com.example.model.Note
import com.example.screen.NoteScreen
import com.example.screen.NoteViewModel
import com.example.screen.NotesScrennPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Houcem_NotesTheme {

val noteViewModel :NoteViewModel by viewModels()
                NotesApp(noteViewModel)


            }
        }
    }
}



@Composable
fun NotesApp(
    noteViewModel: NoteViewModel= viewModel() ){
    val notesList=noteViewModel.getAllNotes()

    NoteScreen(notes = notesList,
        onAddNote =
        {noteViewModel.addNote(it)},
        onRemoveNote ={noteViewModel.removeNote(it)} )

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Houcem_NotesTheme {
    }
}