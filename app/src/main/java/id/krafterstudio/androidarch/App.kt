package id.krafterstudio.androidarch

import android.app.Application
import com.evernote.android.job.JobManager
import id.krafterstudio.androidarch.data.job.NoteJobCreator
import io.realm.Realm
import io.realm.RealmConfiguration


/**
 * Created by sjarifhd on 10/12/18.
 * Innovation, eFishery
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config = RealmConfiguration.Builder().name("arch.realm").build()
        Realm.setDefaultConfiguration(config)

        JobManager.create(this).addJobCreator(NoteJobCreator())
    }
}