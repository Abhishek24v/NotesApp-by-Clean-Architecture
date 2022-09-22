package com.example.cleanarchitecturenoteapp.feature_note.data.repository

import com.example.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDao
import com.example.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.example.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return deleteNote(note)
    }
}