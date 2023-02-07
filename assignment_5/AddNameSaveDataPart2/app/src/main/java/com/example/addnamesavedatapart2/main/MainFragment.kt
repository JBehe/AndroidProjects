package com.example.addnamesavedatapart2.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.addnamesavedatapart2.R

import com.example.addnamesavedatapart2.databinding.FragmentMainBinding
import com.example.addnamesavedatapart2.BR.myViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.setVariable(myViewModel, viewModel)

        binding.button.setOnClickListener{
            binding.myViewModel = viewModel
            viewModel.outputText = viewModel.inputText
            //binding.myViewModel
        }

    }
    /*private fun addName(){
        val name =binding.inputText.text.toString()
        viewModel
        displayNames()

    }
    private fun displayNames(){
        var nameList = viewModel.inputText
        var list = " "
        for (name in nameList){
            list+=name +"\n"

        }
        binding.outputText.setText(list)
        binding.inputText.text.clear()
        binding.inputText.hasFocus()
    }*/


}
