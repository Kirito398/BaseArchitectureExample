package ru.sir.presentation.base.recycler_view

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class BaseViewHolder<M : Any?, I : RecyclerViewBaseItem<M, B>, B : ViewBinding>(
    private val binding: ViewBinding,
    private val viewModel: I
) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(item: M) {
        viewModel.bindData(item)
    }
}
