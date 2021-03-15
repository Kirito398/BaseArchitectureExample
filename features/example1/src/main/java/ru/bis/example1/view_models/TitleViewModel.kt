package ru.bis.example1.view_models

import androidx.databinding.ObservableField
import ru.sir.presentation.base.recycler_view.RecyclerViewBaseItem

class TitleViewModel : RecyclerViewBaseItem<String, Example1ViewModel>() {
    val title = ObservableField("")

    override fun bindData(data: String) {
        title.set(data)
    }
}