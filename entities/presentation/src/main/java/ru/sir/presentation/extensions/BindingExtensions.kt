package ru.sir.presentation.extensions

import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean

fun ObservableBoolean.onChanged(f: (newValue: Boolean) -> Unit): ObservableBoolean {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            f(get())
        }
    })
    return this
}