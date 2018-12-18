package id.krafterstudio.androidarch.di.module

import dagger.Module
import dagger.Provides
import id.krafterstudio.androidarch.data.note.NoteRepoImp
import id.krafterstudio.androidarch.data.note.NoteRepoSyncImp
import id.krafterstudio.androidarch.domain.note.NoteRepo
import id.krafterstudio.androidarch.domain.note.NoteRepoSync

/**
 * Created by sjarifhd on 18/12/18.
 * Innovation, eFishery
 */
@Module
class NoteModule {

    @Provides
    fun provideNoteRepo(noteRepoImp: NoteRepoImp): NoteRepo = noteRepoImp

    @Provides
    fun provideNoteRepoSync(noteRepoSyncImp: NoteRepoSyncImp): NoteRepoSync = noteRepoSyncImp
}