package com.aold.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.aold.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.aold.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.aold.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Заголовок заметки не может быть пустым.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Заголовок заметки не может быть пустым.")
        }
        repository.insertNote(note)
    }
}