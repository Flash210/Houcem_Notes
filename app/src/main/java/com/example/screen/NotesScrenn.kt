package com.example.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componets.NoteButton
import com.example.componets.NoteInputText
import com.example.model.Note


@Composable
fun NoteScreen(
    notes:List<Note>,
    onAddNote:(Note) ->Unit,
    onRemoveNote:(Note) ->Unit

) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember{
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(6.dp)
    ) {

        // app bar
        TopAppBar(
            title = { Text(text = "App Name") },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Notifications")
            },
            backgroundColor = Color((0xFFDADFE3))
        )

        // Content of the column

        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
  NoteInputText(
      modifier = Modifier.padding(top=9.dp, bottom = 8.dp),
      text = title,
      label = "Title ",
      onTextChange ={
          if ( it.all{
              char->
                  char.isLetter() || char.isWhitespace()
              })
              title=it
      } )


            NoteInputText(
                modifier = Modifier.padding(top=9.dp, bottom = 8.dp),

                text = description,
                label ="Add a Note" ,
                onTextChange = {
                    if ( it.all{
                                char->
                            char.isLetter() || char.isWhitespace()
                        })
                        description=it
                })

            NoteButton(text = "Save",
                onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty())
                    {
                        title=""
                        description=""
                    }

                })

        }

    }
}


@Preview(showBackground = true)
@Composable
fun NotesScrennPreview()
{
    NoteScreen(notes= emptyList<Note>(),
        onAddNote = {},
    onRemoveNote = {}
        )
}