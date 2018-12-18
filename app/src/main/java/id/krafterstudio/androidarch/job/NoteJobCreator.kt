package id.krafterstudio.androidarch.job

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator
import id.krafterstudio.androidarch.domain.note.NoteRepoSync
import id.krafterstudio.androidarch.interactor.AddNoteJob
import id.krafterstudio.androidarch.interactor.GetNotesJob
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
@Singleton
class NoteJobCreator
@Inject constructor(private val noteRepoSync: NoteRepoSync) : JobCreator {

    override fun create(tag: String): Job? {
        return when (tag) {
            GetNotesJob.TAG -> return GetNotesJob(noteRepoSync)
            AddNoteJob.TAG -> return AddNoteJob(noteRepoSync)
            else -> null
        }
    }
}