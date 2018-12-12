package id.krafterstudio.androidarch.view.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import id.krafterstudio.androidarch.data.local.NoteLocalImp
import id.krafterstudio.androidarch.domain.note.GetNotes
import io.reactivex.Flowable


/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
class NoteViewModel(
    private val usecase: GetNotes
) :
    ViewModel() {

    var notesLiveData: LiveData<List<NoteView>> = LiveDataReactiveStreams.fromPublisher(
        usecase.execute().flatMap {
            Flowable.just(it.flatMap {
                listOf(NoteView(it.title, it.body, it.createdAt))
            })
        }
    )
}