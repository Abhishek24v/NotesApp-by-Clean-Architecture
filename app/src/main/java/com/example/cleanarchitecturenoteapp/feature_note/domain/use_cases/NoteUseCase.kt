package com.example.cleanarchitecturenoteapp.feature_note.domain.use_cases

import com.example.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder

data class NoteUseCase(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNote: AddNoteUseCase
)
