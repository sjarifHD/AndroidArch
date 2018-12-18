package id.krafterstudio.androidarch.data.note

import id.krafterstudio.androidarch.domain.note.Note
import id.krafterstudio.androidarch.domain.note.NoteRepo
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
@Singleton
class NoteRemoteImp
@Inject constructor(private val noteService: NoteService) : NoteRepo {

    override fun getNotes(): Flowable<List<Note>> {
        return noteService.getNotes()
            .flatMap { response ->
                Flowable.just(response.map {
                    Note(it.id, it.title, it.body, it.createdAt.toString())
                })
            }
            .onErrorReturn { listOf() }
    }

    override fun addNote(note: Note): Completable {
        return noteService.addNote(
            NoteRemote(
                note.id,
                note.title,
                note.body,
                note.createdAt.toLong()
            )
        )
    }
}