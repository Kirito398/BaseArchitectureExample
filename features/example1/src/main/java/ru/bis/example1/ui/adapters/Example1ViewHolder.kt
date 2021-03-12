package ru.bis.example1.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import ru.bis.example1.databinding.ItemExample1Binding
import ru.bis.example1.view_models.ItemViewModel

class Example1ViewHolder(private val binding: ItemExample1Binding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.viewModel = ItemViewModel()
    }

    fun bind(item: String) {
        binding.viewModel?.title?.set(item)
    }
}