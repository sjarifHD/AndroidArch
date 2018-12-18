package id.krafterstudio.androidarch.interactor

import id.krafterstudio.androidarch.domain.note.Note
import id.krafterstudio.androidarch.domain.note.NoteRepo
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
@Singleton
class GetNotes
@Inject constructor(private val noteRepo: NoteRepo) {

    fun execute(): Flowable<List<Note>> {
        return noteRepo.getNotes().onBackpressureBuffer()
    }
}