package ru.sir.recycler_view_example.view_models

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableList
import ru.sir.core.None
import ru.sir.presentation.base.BaseViewModel
import ru.sir.presentation.base.recycler_view.RecyclerViewAdapter
import ru.sir.presentation.base.recycler_view.RecyclerViewBaseDataModel
import ru.sir.recycler_view_example.BR
import ru.sir.recycler_view_example.R
import ru.sir.recycler_view_example_api.interactor.LoadData
import ru.sir.recycler_view_example_api.models.Item
import javax.inject.Inject

class RecyclerViewExampleViewModel @Inject constructor(
    application: Application,
    private val loadData: LoadData
) : BaseViewModel(application) {
    companion object {
        private const val RV_TITLE = 1
        private const val RV_ITEM = 2
    }

    val isLoading = ObservableBoolean(false)
    private lateinit var items: ObservableArrayList<RecyclerViewBaseDataModel>

    override fun init() {
        isLoading.set(true)
        loadData(None()) { it.either({}, ::onDataLoaded) }
    }

    private fun onDataLoaded(data: List<Item>) {
        items.addAll(data.toRecyclerViewItems())
        isLoading.set(false)
    }

    fun recyclerViewAdapter() = RecyclerViewAdapter.Builder(this, BR.viewModel)
        .addProducer(RV_TITLE, R.layout.item_title, String::class.java, TitleViewModel::class.java)
        .addProducer(RV_ITEM, R.layout.item_example1, String::class.java, ItemViewModel::class.java)
        .build()
        .getObserver { items = it }

    private fun List<Item>.toRecyclerViewItems(): List<RecyclerViewBaseDataModel> {
        val newList = mutableListOf<RecyclerViewBaseDataModel>()
        this.forEach { newList.add(RecyclerViewBaseDataModel(it.name, it.type)) }
        return newList
    }
}