package ru.sir.presentation.extensions

import androidx.databinding.Observable
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableList

fun ObservableBoolean.onChanged(f: (newValue: Boolean) -> Unit): ObservableBoolean {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            f(get())
        }
    })
    return this
}

fun <T> ObservableArrayList<T>.onChanged(f: ObservableArrayList<T>.() -> Unit): ObservableArrayList<T> {
    addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<*>>() {
        override fun onChanged(sender: ObservableList<*>?) { f() }
        override fun onItemRangeChanged(sender: ObservableList<*>?, positionStart: Int, itemCount: Int) { f() }
        override fun onItemRangeInserted(sender: ObservableList<*>?, positionStart: Int, itemCount: Int) { f() }
        override fun onItemRangeMoved(sender: ObservableList<*>?, fromPosition: Int, toPosition: Int, itemCount: Int) { f() }
        override fun onItemRangeRemoved(sender: ObservableList<*>?, positionStart: Int, itemCount: Int) { f() }
    })
    return this
}