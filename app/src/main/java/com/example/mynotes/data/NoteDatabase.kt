package com.example.mynotes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mynotes.converter.DateConverter
import com.example.mynotes.converter.UUIDConverter
import com.example.mynotes.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao():NoteDatabaseDao
}