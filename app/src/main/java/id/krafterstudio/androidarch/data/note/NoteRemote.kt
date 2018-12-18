package id.krafterstudio.androidarch.data.note

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
data class NoteRemote(
    @SerializedName("_id") @Expose val id: String,
    @SerializedName("title") @Expose val title: String,
    @SerializedName("body") @Expose val body: String,
    @SerializedName("created_at") @Expose val createdAt: Long
)