package com.atuti.notesapp.repository

import androidx.lifecycle.LiveData
import com.atuti.notesapp.Dao.NoteDao
import com.atuti.notesapp.model.Note

class NoteRepository(private val noteDao:NoteDao) {

    private val allNotes:LiveData<List<Note>> = noteDao.getAllNotes()

    fun insert(note: Note) =  noteDao.insert(note)
    fun update(note: Note) = noteDao.update(note)
    fun delete(note: Note) =  noteDao.delete(note)
    fun getAll():LiveData<List<Note>> {
        return allNotes
    }
}