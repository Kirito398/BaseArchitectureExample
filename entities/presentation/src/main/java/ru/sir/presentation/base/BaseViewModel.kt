package ru.sir.presentation.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.*

open class BaseViewModel(application: Application) : AndroidViewModel(application), LifecycleObserver {
    open fun init() = Unit

    protected val context: Context
        get() = getApplication()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected open fun onCreate() = Unit

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected open fun onStart() = Unit

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected open fun onResume() = Unit

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected open fun onPause() = Unit

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected open fun onStop() = Unit

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected open fun onDestroy() = Unit
}