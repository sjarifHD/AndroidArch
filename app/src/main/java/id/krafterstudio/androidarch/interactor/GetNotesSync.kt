package id.krafterstudio.androidarch.interactor

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by sjarifhd on 12/12/18.
 * Innovation, eFishery
 */
@Singleton
class GetNotesSync @Inject constructor() {

    fun execute() {
        GetNotesJob.schedule()
    }
}