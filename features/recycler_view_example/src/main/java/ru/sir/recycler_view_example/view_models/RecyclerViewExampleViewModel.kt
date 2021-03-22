package ru.sir.recycler_view_example.view_models

import android.app.Application
import ru.sir.presentation.base.BaseViewModel
import ru.sir.presentation.base.recycler_view.RecyclerViewAdapter
import ru.sir.presentation.base.recycler_view.RecyclerViewBaseDataModel
import ru.sir.recycler_view_example.BR
import ru.sir.recycler_view_example.R
import javax.inject.Inject

class RecyclerViewExampleViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    companion object {
        private const val RV_TITLE = 1
        private const val RV_ITEM = 2
    }

    val items = mutableListOf(
        RecyclerViewBaseDataModel("Title 1", RV_TITLE),
        RecyclerViewBaseDataModel("Label 1", RV_ITEM),
        RecyclerViewBaseDataModel("Title 2", RV_TITLE),
        RecyclerViewBaseDataModel("Label 1", RV_ITEM),
        RecyclerViewBaseDataModel("Label 2", RV_ITEM),
        RecyclerViewBaseDataModel("Label 3", RV_ITEM),
        RecyclerViewBaseDataModel("Title 3", RV_TITLE),
        RecyclerViewBaseDataModel("Label 1", RV_ITEM),
        RecyclerViewBaseDataModel("Label 2", RV_ITEM),
        RecyclerViewBaseDataModel("Label 3", RV_ITEM),
        RecyclerViewBaseDataModel("Label 4", RV_ITEM)
    )

    fun recyclerViewAdapter() = RecyclerViewAdapter.Builder(this, BR.viewModel)
        .addProducer(RV_TITLE, R.layout.item_title, String::class.java, TitleViewModel::class.java)
        .addProducer(RV_ITEM, R.layout.item_example1, String::class.java, ItemViewModel::class.java)
        .build(items)
}