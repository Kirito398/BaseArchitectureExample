package ru.sir.presentation.base.recycler_view

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ru.sir.presentation.base.BaseViewModel

class BaseViewHolder<M, I : RecyclerViewBaseItem<M, out BaseViewModel>>(
    private val binding: ViewDataBinding,
    private val viewModel: I
) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(item: M) {
        viewModel.bindData(item)
    }
}
