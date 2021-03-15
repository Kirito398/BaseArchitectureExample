package ru.sir.presentation.extensions

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.sir.presentation.base.recycler_view.RecyclerViewAdapter

@BindingAdapter(value = ["recyclerAdapter"], requireAll = false)
fun setRecyclerAdapter(view: RecyclerView, adapter: RecyclerViewAdapter) {
    view.adapter = adapter
}