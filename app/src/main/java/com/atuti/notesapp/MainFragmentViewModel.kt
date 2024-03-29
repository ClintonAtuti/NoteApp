package com.atuti.notesapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.atuti.notesapp.Dao.NoteDao
import com.atuti.notesapp.model.Note
import com.atuti.notesapp.repository.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    private val noteRepository: NoteRepository,
    dataSource: NoteDao,
    application: Application
) : ViewModel() {
    class MainFragmentViewModel(){}

    val allNotes: LiveData<List<Note>> = noteRepository.getAll()

    fun insert(note: Note) {
        CoroutineScope(IO).launch {
            noteRepository.insert(note)
        }
    }

    fun update(note: Note) {
        CoroutineScope(IO).launch {
            noteRepository.update(note)
        }
    }

    fun delete(note: Note) {
        CoroutineScope(IO).launch {
            noteRepository.delete(note)
        }
    }

    fun getAll(): LiveData<List<Note>> {
        return noteRepository.getAll()

    }


}