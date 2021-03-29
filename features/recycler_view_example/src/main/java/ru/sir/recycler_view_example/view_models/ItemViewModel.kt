package ru.sir.recycler_view_example.view_models

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import ru.sir.presentation.base.recycler_view.RecyclerViewBaseItem
import ru.sir.presentation.extensions.launchOn
import ru.sir.recycler_view_example.databinding.ItemExample1Binding

class ItemViewModel : RecyclerViewBaseItem<String, RecyclerViewExampleViewModel, ItemExample1Binding>() {
    private val title = MutableStateFlow("")

    override fun initVars(binding: ItemExample1Binding) {
        title.launchOn(parent.viewModelScope) {
            binding.title.text = it
        }
    }

    override fun bindData(data: String) {
        title.value = data
    }
}