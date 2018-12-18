package id.krafterstudio.androidarch.domain.note

import id.krafterstudio.androidarch.domain.note.Note

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
interface NoteRepoSync {
    fun getNotes()
    fun addNote(note: Note)
}