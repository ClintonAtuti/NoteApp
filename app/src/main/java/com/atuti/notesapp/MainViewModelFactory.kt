package com.atuti.notesapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atuti.notesapp.Dao.NoteDao
import com.atuti.notesapp.repository.NoteRepository

class MainViewModelFactory(val repository: NoteRepository, val dataSource: NoteDao, val application: Application)
     : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainFragmentViewModel::class.java)) {
                return MainFragmentViewModel(repository, dataSource, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}