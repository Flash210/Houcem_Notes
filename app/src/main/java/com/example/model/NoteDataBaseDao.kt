package com.example.model

import androidx.compose.runtime.MutableState
import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDataBaseDao {



    // we dont use suspend here beacuse we talk here about
    // another concept (we are going to wrap this notes list around)
    @Query(value = "SELECT * from notes_tbl")
      fun getNotes():Flow<List<Note>>


    @Query(value = "SELECT * from notes_tbl where id=:id")
   suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend  fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
   suspend fun update(note: Note)


    @Query(value = "DELETE from notes_tbl")
  suspend  fun deleteAll()


    @Delete
    suspend fun deleteNote(note: Note)

}