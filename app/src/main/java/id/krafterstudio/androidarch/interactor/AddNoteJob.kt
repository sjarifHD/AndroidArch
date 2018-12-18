package id.krafterstudio.androidarch.interactor

import android.os.Bundle
import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import id.krafterstudio.androidarch.domain.note.Note
import id.krafterstudio.androidarch.domain.note.NoteRepoSync
import javax.inject.Inject


/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
class AddNoteJob
@Inject constructor(private val noteRepoSync: NoteRepoSync) : Job() {

    companion object {
        const val TAG = "add_note_job"
        const val KEY_NOTE = "note"

        fun schedule(note: Note): Int {
            val bundle = Bundle()
            bundle.putSerializable(KEY_NOTE, note)

            return JobRequest.Builder(TAG)
                .setTransientExtras(bundle)
                .setExecutionWindow(3_000L, 10_000L)
                .setUpdateCurrent(true)
                .setRequiredNetworkType(JobRequest.NetworkType.CONNECTED)
                .setRequiresStorageNotLow(true)
                .setRequiresBatteryNotLow(true)
                .setRequirementsEnforced(true)
                .build()
                .schedule()
        }
    }

    override fun onRunJob(params: Params): Result {
        val bundle = params.transientExtras
        val note: Note = bundle.get(KEY_NOTE) as Note

        noteRepoSync.addNote(note)
        return Result.SUCCESS
    }
}