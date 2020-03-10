package com.gulshansutey.takemynotes

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gulshansutey.takemynotes.adapters.NotesRecyclerViewAdapter
import com.gulshansutey.takemynotes.databinding.ActivityMainBinding
import com.gulshansutey.takemynotes.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var adapter: NotesRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.setVariable(BR._all, viewModel)
        dataBinding.executePendingBindings()
        setupNotesList()
        viewModel.noteList.observe(this, Observer {
            adapter.setNotes(it)
        })
    }

    fun View.onFabClick() {

    }

    private fun setupNotesList() {
        adapter = NotesRecyclerViewAdapter()
        dataBinding.layoutContentMain.rvNoteList.adapter = adapter
    }

}
