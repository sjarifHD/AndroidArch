package id.krafterstudio.androidarch.infrastructure.data.note

import id.krafterstudio.androidarch.domain.note.Note
import id.krafterstudio.androidarch.domain.note.NoteRepoSync
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
@Singleton
class NoteRepoSyncImp
@Inject constructor(
    private val noteLocalImp: NoteLocalImp,
    private val noteRemoteImp: NoteRemoteImp
) : NoteRepoSync {

    override fun getNotes() {
        noteRemoteImp.getNotes().doOnNext {
            it.forEach { noteLocalImp.addNote(it).subscribe() }
        }.subscribe()
    }

    override fun addNote(note: Note) {
        noteRemoteImp.addNote(note).subscribe()
        // todo sync with local
    }
}