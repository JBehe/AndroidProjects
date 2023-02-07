package com.example.lifecycleawarenessproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LifecycleObserver
import com.example.lifecycleawarenessproject.R
import com.example.lifecycleawarenessproject.demoObserver


class mainViewModel : ViewModel(){
    companion object{
        private var textData = ""
        public val resultText: MutableLiveData<String> = MutableLiveData()
    fun updateText(msg: String){
        textData += msg
        resultText.setValue(textData)
    }

    }
    fun getText():MutableLiveData<String> {
        return resultText
    }
}