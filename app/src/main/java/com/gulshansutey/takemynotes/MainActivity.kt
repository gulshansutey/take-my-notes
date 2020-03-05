package com.gulshansutey.takemynotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gulshansutey.takemynotes.databinding.ActivityMainBinding
import com.gulshansutey.takemynotes.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val dataBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.setVariable(BR._all, viewModel)
        dataBinding.lifecycleOwner = this
    }
}
