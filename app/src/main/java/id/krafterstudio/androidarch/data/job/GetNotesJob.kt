package id.krafterstudio.androidarch.data.job

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import id.krafterstudio.androidarch.data.local.NoteLocalImp
import id.krafterstudio.androidarch.data.note.NoteRepoSyncImp
import id.krafterstudio.androidarch.data.remote.NoteApi
import id.krafterstudio.androidarch.data.remote.NoteRemoteImp
import id.krafterstudio.androidarch.domain.repository.NoteRepoSync


/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
class GetNotesJob() : Job() {

    private lateinit var noteRepoSync: NoteRepoSync
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
        noteRepoSync = NoteRepoSyncImp(NoteLocalImp(), NoteRemoteImp(NoteApi.INSTANCE))
        noteRepoSync.getNotes()
        return Result.SUCCESS
    }
}