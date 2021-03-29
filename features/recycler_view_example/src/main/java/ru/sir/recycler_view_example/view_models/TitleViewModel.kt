package ru.sir.recycler_view_example.view_models

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.MutableStateFlow
import ru.sir.presentation.base.recycler_view.RecyclerViewBaseItem
import ru.sir.presentation.extensions.launchWhenStarted
import ru.sir.recycler_view_example.databinding.ItemTitleBinding

class TitleViewModel : RecyclerViewBaseItem<String, ItemTitleBinding>() {
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