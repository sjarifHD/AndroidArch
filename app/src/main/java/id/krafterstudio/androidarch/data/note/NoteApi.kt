package id.krafterstudio.androidarch.data.note

import io.reactivex.Completable
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
interface NoteApi {
    @GET("notes")
    fun getNotes(): Flowable<MutableList<NoteRemote>>

    @POST("notes")
    fun addNote(note: NoteRemote): Completable

    companion object {
        private const val URL = "https://expressnote.herokuapp.com/"
    }
}