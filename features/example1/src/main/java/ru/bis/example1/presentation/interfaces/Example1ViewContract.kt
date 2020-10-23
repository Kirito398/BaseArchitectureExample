package ru.bis.example1.presentation.interfaces

import androidx.lifecycle.LifecycleObserver
import ru.bis.entities.None

interface Example1ViewContract {
    interface View {
        fun init()
        fun setListeners()
        fun onLoadDataFromCacheSuccess(data: String)
        fun onLoadDataFromCacheFailed(failed: None)
    }

    interface Presenter : LifecycleObserver {
        fun setView(view: View)
        fun init()
    }
}