package id.krafterstudio.androidarch.domain.note

import id.krafterstudio.androidarch.domain.repository.NoteRepo
import io.reactivex.Flowable

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
class GetNotes(private val noteRepo: NoteRepo) {

    fun execute(): Flowable<List<Note>> {
        return noteRepo.getNotes().onBackpressureBuffer()
    }
}