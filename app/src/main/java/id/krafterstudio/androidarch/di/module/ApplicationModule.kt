package id.krafterstudio.androidarch.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import id.krafterstudio.androidarch.App
import javax.inject.Singleton

/**
 * Created by sjarifhd on 18/12/18.
 * Innovation, eFishery
 */
@Module
class ApplicationModule(private val application: App) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application
}