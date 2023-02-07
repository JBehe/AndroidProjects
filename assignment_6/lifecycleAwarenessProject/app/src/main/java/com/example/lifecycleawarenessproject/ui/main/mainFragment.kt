package com.example.lifecycleawarenessproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import androidx.lifecycle.SavedStateHandle
import com.example.lifecycleawarenessproject.R
import androidx.lifecycle.ViewModel
import com.example.lifecycleawarenessproject.demoObserver



class mainFragment : Fragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val  viewModel = ViewModelProvider(this ).get(mainViewModel::class.java)
        lifecycle.addObserver(demoObserver())

        val resultObserver = Observer<String>{
            result -> lifecycle.currentState
        }
            viewModel.getText().observe(viewLifecycleOwner, resultObserver)

    }
}