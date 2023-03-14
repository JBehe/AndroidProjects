package com.example.lifecycleawarenessproject.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lifecycleawarenessproject.databinding.FragmentMainBinding


class mainViewModel : ViewModel(){

    companion object{


        private var textData = ""
       // lateinit var  binding: FragmentMainBinding
        val resultText: MutableLiveData<String> = MutableLiveData()
        fun updateText(msg: String){
            textData += msg
            resultText.value = textData
        }
    }

    fun getText():MutableLiveData<String> {
        return resultText
    }

}