package com.example.mynotes.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotes.model.Note
import com.example.mynotes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {
    //private var noteList = mutableStateListOf<Note>()

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList
    init{
        //noteList.addAll(NotesDataSource().loadNotes())

        viewModelScope.launch( Dispatchers.IO){
            repository.getAllNote().distinctUntilChanged()
                .collect{listOfNote->
                    if (listOfNote.isEmpty()){
                        Log.d("Empty",":Empty List")
                    }else{
                        _noteList.value = listOfNote
                    }
                }
        }

    }
    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch{ repository.update(note) }
    fun removeNote(note: Note) = viewModelScope.launch{ repository.deleteNote(note) }

}