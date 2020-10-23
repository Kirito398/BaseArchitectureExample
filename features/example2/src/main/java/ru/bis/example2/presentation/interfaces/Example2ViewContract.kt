package ru.bis.example2.presentation.interfaces

import androidx.lifecycle.LifecycleObserver

interface Example2ViewContract {
    interface View {
        fun init()
        fun setListeners()
        fun showProgressBar()
        fun hideProgressBar()
        fun setText(text: String)
    }

    interface Presenter : LifecycleObserver {
        fun setView(view: View)
        fun init()
    }
}