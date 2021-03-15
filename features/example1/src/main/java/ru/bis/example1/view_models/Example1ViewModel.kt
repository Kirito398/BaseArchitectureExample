package ru.bis.example1.view_models

import android.app.Application
import androidx.databinding.ObservableField
import ru.bis.example1.BR
import ru.bis.example1.R
import ru.bis.example1_api.interactor.GetDataFromCache
import ru.sir.core.None
import ru.sir.presentation.base.BaseViewModel
import ru.sir.presentation.base.recycler_view.RecyclerViewAdapter
import ru.sir.presentation.base.recycler_view.RecyclerViewBaseDataModel
import javax.inject.Inject

class Example1ViewModel @Inject constructor(
    application: Application,
    private val getDataFromCache: GetDataFromCache
    ) : BaseViewModel(application) {

    val result = ObservableField<String>()
    val items = mutableListOf(
        RecyclerViewBaseDataModel("Label 1", 1),
        RecyclerViewBaseDataModel("Label 2", 1),
        RecyclerViewBaseDataModel("Label 3", 1),
        RecyclerViewBaseDataModel("Label 4", 1),
        RecyclerViewBaseDataModel("Label 5", 1),
        RecyclerViewBaseDataModel("Label 6", 1)
    )

    override fun init() {
        getDataFromCache(None()) { it.either(::onLoadDataFromCacheFailed, ::onLoadDataFromCacheSuccess) }
    }

    private fun onLoadDataFromCacheSuccess(data: String) {
        result.set(data)
    }

    private fun onLoadDataFromCacheFailed(failed: None) {
        result.set(context.getString(R.string.load_data_failed))
    }

    fun recyclerViewAdapter() = RecyclerViewAdapter.Builder(this, BR.viewModel)
            .addProducer(1, R.layout.item_example1, String::class.java, ItemViewModel::class.java)
            .build(items)
}