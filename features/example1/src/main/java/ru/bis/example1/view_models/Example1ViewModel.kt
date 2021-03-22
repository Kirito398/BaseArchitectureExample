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

    companion object {
        private const val RV_TITLE = 1
        private const val RV_ITEM = 2
    }

    val result = ObservableField<String>()
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
            .addProducer(RV_TITLE, R.layout.item_title, String::class.java, TitleViewModel::class.java)
            .addProducer(RV_ITEM, R.layout.item_example1, String::class.java, ItemViewModel::class.java)
            .build(items)
}