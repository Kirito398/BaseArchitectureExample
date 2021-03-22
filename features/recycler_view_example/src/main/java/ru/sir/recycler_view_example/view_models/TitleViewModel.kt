package ru.sir.recycler_view_example.view_models

import androidx.databinding.ObservableField
import ru.sir.presentation.base.recycler_view.RecyclerViewBaseItem

class TitleViewModel : RecyclerViewBaseItem<String, RecyclerViewExampleViewModel>() {
    val title = ObservableField("")

    override fun bindData(data: String) {
        title.set(data)
    }
}