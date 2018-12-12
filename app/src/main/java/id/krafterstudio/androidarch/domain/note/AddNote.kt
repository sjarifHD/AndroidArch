package id.krafterstudio.androidarch.domain.note

import id.krafterstudio.androidarch.domain.repository.NoteRepo

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
class AddNote(private val noteRepo: NoteRepo) {

    fun execute(note: Note) {
        noteRepo.addNote(note).subscribe()
    }
}