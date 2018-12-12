package id.krafterstudio.androidarch.domain.note

import id.krafterstudio.androidarch.data.job.GetNotesJob
import id.krafterstudio.androidarch.domain.repository.NoteRepoSync

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
class GetNotesSync(private val noteRepoSync: NoteRepoSync) {

    fun execute() {
        GetNotesJob.schedule()
    }
}