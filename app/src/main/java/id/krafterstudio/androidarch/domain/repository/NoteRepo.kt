package id.krafterstudio.androidarch.domain.repository

import id.krafterstudio.androidarch.domain.note.Note
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
interface NoteRepo {

    fun getNotes(): Flowable<List<Note>>

    fun addNote(note: Note): Completable
}