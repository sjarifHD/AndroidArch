package id.krafterstudio.androidarch.interactor

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import id.krafterstudio.androidarch.domain.note.NoteRepoSync
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
@Singleton
class GetNotesJob
@Inject constructor(private val noteRepoSync: NoteRepoSync) : Job() {

    companion object {
        const val TAG = "get_note_job"

        fun schedule(): Int {
            return JobRequest.Builder(TAG)
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
        noteRepoSync.getNotes()
        return Result.SUCCESS
    }
}