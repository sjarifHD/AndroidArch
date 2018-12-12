package id.krafterstudio.androidarch.domain.note

import java.io.Serializable

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
data class Note(val id: String, val title: String, val body: String, val createdAt: String) : Serializable