package id.krafterstudio.androidarch.interactor

import id.krafterstudio.androidarch.domain.note.Note
import id.krafterstudio.androidarch.domain.note.NoteRepo

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
class AddNote(private val noteRepo: NoteRepo) {

    fun execute(note: Note) {
        noteRepo.addNote(note).subscribe()
    }
}