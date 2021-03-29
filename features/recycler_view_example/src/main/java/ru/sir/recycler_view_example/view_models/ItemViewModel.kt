package ru.sir.recycler_view_example.view_models

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.MutableStateFlow
import ru.sir.presentation.base.recycler_view.RecyclerViewBaseItem
import ru.sir.presentation.extensions.launchWhenStarted
import ru.sir.recycler_view_example.databinding.ItemExample1Binding

class ItemViewModel : RecyclerViewBaseItem<String, ItemExample1Binding>() {
    private val title = MutableStateFlow("")

    override fun initVars() {
        title.launchWhenStarted(parent.lifecycleScope) {
            binding.title.text = it
        }
    }

    override fun bindData(data: String) {
        title.value = data
    }
}