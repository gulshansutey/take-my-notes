package com.gulshansutey.takemynotes.viewmodels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulshansutey.takemynotes.models.Note
import java.util.*


/**
 * @author gulshansutey
 * @see androidx.lifecycle.ViewModel
 *
 *
 * MainActivityViewModel will retrive the data from DataModels, applies the UI logic and expose
 * appropriate data from data model to the view.
 *
 *
 * *Notes- This MainActivityViewModel should not contain any info or reference of any view, but should expose the data for
 * a view to bind with, and the consume or view should notify the viewmodel back for any action.
 */
class MainActivityViewModel : ViewModel() {

    val noteList = MutableLiveData<ArrayList<Note>>()

    init {
        noteList.value = ArrayList()
    }

    fun addNote(note: Note) {
        noteList.value?.add(note)
        noteList.value = noteList.value
    }

}
