package ru.sir.presentation.base.recycler_view

import ru.sir.presentation.base.BaseViewModel

abstract class RecyclerViewBaseItem<M, VM : BaseViewModel> {
    protected lateinit var parent: VM

    fun init(parent: VM) {
        this.parent = parent
    }

    abstract fun bindData(data: M)
}