package id.krafterstudio.androidarch.infrastructure.data.note

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by sjarifhd on 18/12/18.
 * Innovation, eFishery
 */
@Singleton
class NoteService
@Inject constructor(private var retrofit: Retrofit) : NoteApi {

    private val noteService by lazy { retrofit.create(NoteApi::class.java) }

    override fun getNotes() = noteService.getNotes()

    override fun addNote(note: NoteRemote) = noteService.addNote(note)
}