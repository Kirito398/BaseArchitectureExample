package ru.sir.presentation.base.recycler_view

import androidx.viewbinding.ViewBinding
import ru.sir.presentation.base.BaseViewModel

abstract class RecyclerViewBaseItem<M : Any?, VM : BaseViewModel, B : ViewBinding> {
    protected lateinit var parent: VM
    protected lateinit var binding: B

    fun init(parent: VM, binding: B) {
        this.parent = parent
        this.binding = binding
    }

    abstract fun initVars(binding: B)
    abstract fun bindData(data: M)
}