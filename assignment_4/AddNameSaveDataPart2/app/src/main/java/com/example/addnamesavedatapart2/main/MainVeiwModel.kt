package com.example.addnamesavedatapart2.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var inputText: MutableLiveData<String> = MutableLiveData()
    var outputText: MutableLiveData<String> = MutableLiveData()
    //var arr: MutableList<String> = MutableList<String>()


    fun changeText(){
       /*var arr = ArrayList<String>()
        var i = 0
        arr[i] = (inputText.value.toString() )
        outputText.value = arr[i] + "\n" */
        outputText.value = inputText.value
    }
}