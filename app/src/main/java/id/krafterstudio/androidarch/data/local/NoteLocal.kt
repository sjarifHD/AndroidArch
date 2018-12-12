package id.krafterstudio.androidarch.data.local

import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
open class NoteLocal(
    @PrimaryKey var id: String, @Index var title: String,
    var body: String, var createdAt: String
) : RealmObject() {
    constructor() : this("", "", "", "")
}