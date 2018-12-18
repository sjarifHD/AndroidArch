package id.krafterstudio.androidarch

import android.app.Application
import com.evernote.android.job.JobManager
import id.krafterstudio.androidarch.di.component.ApplicationComponent
import id.krafterstudio.androidarch.di.component.DaggerApplicationComponent
import id.krafterstudio.androidarch.di.module.ApplicationModule
import id.krafterstudio.androidarch.di.module.NetworkModule
import id.krafterstudio.androidarch.di.module.NoteModule
import id.krafterstudio.androidarch.job.NoteJobCreator
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject


/**
 * Created by sjarifhd on 10/12/18.
 * Innovation, eFishery
 */
class App : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    @Inject
    lateinit var noteJobCreator: NoteJobCreator

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)

        Realm.init(this)
        val config = RealmConfiguration.Builder().name("arch.realm").build()
        Realm.setDefaultConfiguration(config)

        JobManager.create(this).addJobCreator(noteJobCreator)
    }
}