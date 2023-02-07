package com.example.lifecycleawarenessproject
import android.util.Log
import com.example.lifecycleawarenessproject.ui.main.mainViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner
import java.util.Calendar
class demoObserver: LifecycleObserver {
    private val LOG_TAG  = "DemoObserver"
    public var viewM = mainViewModel
    private var ActivationTime = Calendar.getInstance().time

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.i(LOG_TAG, "onCreate")
        viewM.updateText("onCreate was fired on " + ActivationTime)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.i(LOG_TAG, "onDestroy")
        viewM.updateText("onDestroy was fired on " + ActivationTime)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        Log.i(LOG_TAG, "onStart")
        viewM.updateText("onStart was fired on " + ActivationTime)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        Log.i(LOG_TAG, "onStop")
        viewM.updateText("onStop was fired on " + ActivationTime)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        Log.i(LOG_TAG, "onResume")
        viewM.updateText("onResume was fired on " + ActivationTime)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        Log.i(LOG_TAG, "onPause")
        viewM.updateText("onPause was fired on " + ActivationTime)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner:LifecycleOwner, event: Lifecycle.Event){
        var currentState = owner.lifecycle.currentState.name
        var eventName = event.name
        Log.i(LOG_TAG, owner.lifecycle.currentState.name)

    }

}
