package com.example.mynotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynotes.data.NotesDataSource
import com.example.mynotes.model.Note
import com.example.mynotes.screens.NoteScreen
import com.example.mynotes.ui.theme.MyNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val notes = remember {
                        mutableStateListOf<Note>()
                    }
                    NoteScreen(notes = notes,
                        onRemoveNote = {
                            notes.remove(it)
                        },
                        onAddNote = {
                            notes.add(it)
                        })
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyNotesTheme {
    }
}