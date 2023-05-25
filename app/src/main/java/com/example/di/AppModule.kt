package com.example.di

import android.content.Context
import androidx.room.Room
import com.example.model.NoteDataBaseDao
import com.example.model.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase):NoteDataBaseDao=noteDatabase.noteDao()


    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context:Context):NoteDatabase
    = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "notes_db"
    ).fallbackToDestructiveMigration()
        .build()






    //modules are used to add bindings to hilt .to tell hilt
    //to tell hilt how to provide instance of different types tp create
    // a room db
    // to create room db we need to use a builder to create an instance of teh db
    // because we dont want a db be created every time app stars

    // so this module we can add a mechanism that will
// allow us to instantiate or to create certain dependencies such as create db and provide all of that
}