package id.krafterstudio.androidarch.infrastructure.data.note

import id.krafterstudio.androidarch.domain.note.Note
import id.krafterstudio.androidarch.domain.note.NoteRepo
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
class NoteRepoImp
@Inject constructor(private val noteLocalImp: NoteLocalImp) : NoteRepo {

    override fun getNotes(): Flowable<List<Note>> {
        return noteLocalImp.getNotes()
    }

    override fun addNote(note: Note): Completable {
        return noteLocalImp.addNote(note)
    }
}