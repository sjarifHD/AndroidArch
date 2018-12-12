package id.krafterstudio.androidarch.data.remote

import id.krafterstudio.androidarch.domain.note.Note
import id.krafterstudio.androidarch.domain.repository.NoteRepo
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
class NoteRemoteImp(private val noteApi: NoteApi) : NoteRepo {

    override fun getNotes(): Flowable<List<Note>> {
        return noteApi.getNotes()
            .flatMap { response ->
                Flowable.just(response.map {
                    Note(it.id, it.title, it.body, it.createdAt.toString())
                })
            }
            .onErrorReturn { listOf() }
    }

    override fun addNote(note: Note): Completable {
        return noteApi.addNote(
            NoteRemote(
                note.id,
                note.title,
                note.body,
                note.createdAt.toLong()
            )
        )
    }
}