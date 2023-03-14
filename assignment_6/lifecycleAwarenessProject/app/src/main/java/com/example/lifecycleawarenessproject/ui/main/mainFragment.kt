package com.example.lifecycleawarenessproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.example.lifecycleawarenessproject.databinding.FragmentMainBinding
import com.example.lifecycleawarenessproject.demoObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class mainFragment : Fragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val  viewModel = ViewModelProvider(this ).get(mainViewModel::class.java)
        lifecycle.addObserver(demoObserver())
        lateinit var binding: FragmentMainBinding
        var demo = demoObserver()
        //var resultText = mainViewModel.resultText
        var resultObserver = Observer<String>{
            result -> lifecycle.currentState
            /*if (result == "onCreate"){
                binding.lifecycleDisplay.text = demo.onCreate().toString()
            }*/

        }
           // demo.viewM.updateText

      // if (resultObserver.equals(result)){

      // }
        demo.viewM.updateText(resultObserver.toString())
        viewModel.getText().observe(viewLifecycleOwner, resultObserver)


    }
}


