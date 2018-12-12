package id.krafterstudio.androidarch.data.local

import id.krafterstudio.androidarch.domain.note.Note
import id.krafterstudio.androidarch.domain.repository.NoteRepo
import io.reactivex.Completable
import io.reactivex.Flowable
import io.realm.Realm

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
class NoteLocalImp() : NoteRepo {

    override fun getNotes(): Flowable<List<Note>> {
        val realm = Realm.getDefaultInstance()
        return realm.where(NoteLocal::class.java)
            .findAllAsync()
            .asFlowable()
            .map { realmResults ->
                realm.copyFromRealm(realmResults).flatMap {
                    listOf(Note(it.id, it.title, it.body, it.createdAt))
                }
            }
            .doOnCancel { realm.close() }
            .doOnError { realm.close() }
    }

    override fun addNote(note: Note): Completable {
        val realm = Realm.getDefaultInstance()
        return Completable.fromRunnable {
            realm.executeTransactionAsync {
                it.insertOrUpdate(
                    NoteLocal(
                        note.id,
                        note.title,
                        note.body,
                        note.createdAt
                    )
                )
            }
        }.doOnComplete { realm.close() }.doOnError { realm.close() }
    }
}