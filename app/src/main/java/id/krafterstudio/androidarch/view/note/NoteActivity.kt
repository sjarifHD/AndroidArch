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
import id.krafterstudio.androidarch.App
import id.krafterstudio.androidarch.R
import id.krafterstudio.androidarch.di.component.ApplicationComponent
import id.krafterstudio.androidarch.interactor.GetNotes
import id.krafterstudio.androidarch.interactor.GetNotesSync
import kotlinx.android.synthetic.main.activity_note.*
import javax.inject.Inject


/**
 * Created by sjarifhd on 11/12/18.
 * Innovation, eFishery
 */
class NoteActivity : AppCompatActivity() {

    // 1. get instance component
    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as App).appComponent
    }

    @Inject
    lateinit var noteAdapter: NoteAdapter

    @Inject
    lateinit var noteCase: GetNotes

    @Inject
    lateinit var noteCaseSync: GetNotesSync

    private lateinit var noteViewModelFactory: NoteViewModelFactory
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        // 2. inject to client
        appComponent.inject(this)

        rvNote.layoutManager = LinearLayoutManager(this)
        rvNote.adapter = noteAdapter

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

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}