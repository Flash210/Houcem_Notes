package com.example.houcem_notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.NoteDataSource
import com.example.houcem_notes.ui.theme.Houcem_NotesTheme
import com.example.model.Note
import com.example.screen.NoteScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Houcem_NotesTheme {

                NoteScreen(notes= NoteDataSource().loadNotes(),
                    onAddNote = {},
                    onRemoveNote = {}
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Houcem_NotesTheme {
        Greeting("Android")
    }
}