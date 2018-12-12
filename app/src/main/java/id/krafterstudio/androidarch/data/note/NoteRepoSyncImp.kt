package id.krafterstudio.androidarch.data.note

import id.krafterstudio.androidarch.data.local.NoteLocalImp
import id.krafterstudio.androidarch.data.remote.NoteRemoteImp
import id.krafterstudio.androidarch.domain.note.Note
import id.krafterstudio.androidarch.domain.repository.NoteRepoSync

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
class NoteRepoSyncImp(private val noteLocalImp: NoteLocalImp, private val noteRemoteImp: NoteRemoteImp) : NoteRepoSync {

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