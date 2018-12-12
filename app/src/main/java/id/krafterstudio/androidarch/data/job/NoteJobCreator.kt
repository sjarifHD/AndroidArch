package id.krafterstudio.androidarch.data.job

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
class NoteJobCreator() : JobCreator {

    override fun create(tag: String): Job? {
        return when (tag) {
            GetNotesJob.TAG -> return GetNotesJob()
            AddNoteJob.TAG -> return AddNoteJob()
            else -> null
        }
    }
}