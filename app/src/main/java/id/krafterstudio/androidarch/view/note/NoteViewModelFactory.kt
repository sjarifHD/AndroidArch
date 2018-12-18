package id.krafterstudio.androidarch.view.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.krafterstudio.androidarch.interactor.GetNotes
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
@Singleton
class NoteViewModelFactory
@Inject constructor(private val usecase: GetNotes) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(usecase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class");
    }

//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        val creator = creators[modelClass] ?:
//        creators.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value ?:
//        throw IllegalArgumentException("Unknown ViewModel class " + modelClass)
//
//        return try { creator.get() as T }
//        catch (e: Exception) { throw RuntimeException(e) }
//    }
}