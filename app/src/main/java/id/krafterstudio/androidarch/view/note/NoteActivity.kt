package id.krafterstudio.androidarch.view.note

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import id.krafterstudio.androidarch.R
import id.krafterstudio.androidarch.data.local.NoteLocalImp
import id.krafterstudio.androidarch.data.note.NoteRepoImp
import id.krafterstudio.androidarch.data.note.NoteRepoSyncImp
import id.krafterstudio.androidarch.data.remote.NoteApi
import id.krafterstudio.androidarch.data.remote.NoteRemoteImp
import id.krafterstudio.androidarch.domain.note.GetNotes
import id.krafterstudio.androidarch.domain.note.GetNotesSync
import id.krafterstudio.androidarch.domain.repository.NoteRepo
import id.krafterstudio.androidarch.domain.repository.NoteRepoSync
import kotlinx.android.synthetic.main.activity_note.*


/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
class NoteActivity : AppCompatActivity() {

    private lateinit var noteAdapter: NoteAdapter

    private lateinit var noteApi: NoteApi
    private lateinit var noteLocal: NoteLocalImp
    private lateinit var noteRemote: NoteRemoteImp
    private lateinit var noteRepo: NoteRepo
    private lateinit var noteRepoSync: NoteRepoSync

    private lateinit var noteCase: GetNotes
    private lateinit var noteCaseSync: GetNotesSync

    private lateinit var noteViewModelFactory: NoteViewModelFactory
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        noteAdapter = NoteAdapter()
        rvNote.layoutManager = LinearLayoutManager(this)
        rvNote.adapter = noteAdapter

        // depedencies
        noteApi = NoteApi.INSTANCE
        noteLocal = NoteLocalImp()
        noteRemote = NoteRemoteImp(noteApi)
        noteRepo = NoteRepoImp(noteLocal)
        noteRepoSync = NoteRepoSyncImp(noteLocal, noteRemote)

        noteCase = GetNotes(noteRepo)
        noteCaseSync = GetNotesSync(noteRepoSync)

        noteViewModelFactory = NoteViewModelFactory(noteCase)
        noteViewModel = ViewModelProviders.of(this, noteViewModelFactory).get(NoteViewModel::class.java)
        noteViewModel.notesLiveData.observe(this, Observer {
            if (it.isEmpty()) {
                rvNote.visibility = GONE
                tvNoData.visibility = VISIBLE
            } else {
                noteAdapter.add(it)

                rvNote.visibility = VISIBLE
                tvNoData.visibility = GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_note, menu)
        return true
    }

    var index = 255

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sync -> {
                showToast("Syncing.............")
                noteCaseSync.execute()
                true
            }
            else -> super.onOptionsItemSelected(item);
        }
    }

    private fun showErr(err: String?) {
        showToast(err)
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}