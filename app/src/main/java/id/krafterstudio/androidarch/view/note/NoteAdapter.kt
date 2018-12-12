package id.krafterstudio.androidarch.view.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.krafterstudio.androidarch.R

/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
class NoteAdapter : RecyclerView.Adapter<NoteHolder>() {

    private var notes: List<NoteView> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteHolder(view)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder(notes[position])
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun add(notes: List<NoteView>) {
        this.notes = notes
        notifyDataSetChanged()
    }
}