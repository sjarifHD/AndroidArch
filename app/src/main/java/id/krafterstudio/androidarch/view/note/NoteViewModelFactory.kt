package id.krafterstudio.androidarch.view.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.krafterstudio.androidarch.domain.note.GetNotes

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
class NoteViewModelFactory(private val usecase: GetNotes) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(usecase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class");
    }
}