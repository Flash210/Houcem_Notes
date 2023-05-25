package com.example.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.util.UUUIDConverter


@Database(entities = [Note::class], version = 1, exportSchema = false)

@TypeConverters(UUUIDConverter::class)
abstract class NoteDatabase :RoomDatabase(){


    abstract fun noteDao():NoteDataBaseDao


}