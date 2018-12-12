package id.krafterstudio.androidarch.data.note

import id.krafterstudio.androidarch.data.local.NoteLocalImp
import id.krafterstudio.androidarch.domain.note.Note
import id.krafterstudio.androidarch.domain.repository.NoteRepo
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
class NoteRepoImp(private val noteLocalImp: NoteLocalImp) : NoteRepo {

    override fun getNotes(): Flowable<List<Note>> {
        return noteLocalImp.getNotes()
    }

    override fun addNote(note: Note): Completable {
        return noteLocalImp.addNote(note)
    }
}