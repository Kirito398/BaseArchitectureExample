package ru.sir.presentation.base.recycler_view

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ru.sir.presentation.base.BaseViewModel

class BaseViewHolder<M : Any?, I : RecyclerViewBaseItem<M, out BaseViewModel>>(
    private val binding: ViewDataBinding,
    private val viewModel: I,
    private val viewModelId: Int
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.setVariable(viewModelId, viewModel)
    }

    fun bindData(item: M) {
        viewModel.bindData(item)
    }
}
