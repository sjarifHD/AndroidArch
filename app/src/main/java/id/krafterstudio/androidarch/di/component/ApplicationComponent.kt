package id.krafterstudio.androidarch.di.component

import dagger.Component
import id.krafterstudio.androidarch.App
import id.krafterstudio.androidarch.di.module.ApplicationModule
import id.krafterstudio.androidarch.di.module.NetworkModule
import id.krafterstudio.androidarch.di.module.NoteModule
import id.krafterstudio.androidarch.interactor.GetNotesJob
import id.krafterstudio.androidarch.view.note.NoteActivity
import javax.inject.Singleton

/**
 * Created by sjarifhd on 18/12/18.
 * Innovation, eFishery
 */
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        NoteModule::class
    ]
)
interface ApplicationComponent {
    fun inject(application: App)

    fun inject(noteActivity: NoteActivity)
}