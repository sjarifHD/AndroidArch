package id.krafterstudio.androidarch.view.note

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_note.view.*


/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    operator fun invoke(note: NoteView) {
        itemView.tvTitle.text = note.title
        itemView.tvCreatedAt.text = note.createdAt
    }
}