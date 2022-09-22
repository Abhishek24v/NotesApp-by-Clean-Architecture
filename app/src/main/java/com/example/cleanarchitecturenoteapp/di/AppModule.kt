package com.example.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarchitecturenoteapp.feature_note.data.repository.NoteRepositoryImpl
import com.example.cleanarchitecturenoteapp.feature_note.domain.model.NoteDatabase
import com.example.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.example.cleanarchitecturenoteapp.feature_note.domain.use_cases.AddNoteUseCase
import com.example.cleanarchitecturenoteapp.feature_note.domain.use_cases.DeleteNoteUseCase
import com.example.cleanarchitecturenoteapp.feature_note.domain.use_cases.GetNotesUseCase
import com.example.cleanarchitecturenoteapp.feature_note.domain.use_cases.NoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNoteDatabase(app : Application ) : NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNotesRepository(db : NoteDatabase) : NoteRepository {
        return  NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun providesNoteUserCase(repository : NoteRepository) : NoteUseCase {
        return  NoteUseCase(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNote = AddNoteUseCase(repository)
        )
    }
}