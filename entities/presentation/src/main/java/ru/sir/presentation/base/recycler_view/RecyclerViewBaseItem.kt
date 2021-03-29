package ru.sir.presentation.base.recycler_view

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class RecyclerViewBaseItem<M : Any?, B : ViewBinding> {
    protected lateinit var parent: Fragment
    protected lateinit var binding: B

    fun init(parent: Fragment, binding: B) {
        this.parent = parent
        this.binding = binding

        initVars()
    }

    abstract fun initVars()
    abstract fun bindData(data: M)
}