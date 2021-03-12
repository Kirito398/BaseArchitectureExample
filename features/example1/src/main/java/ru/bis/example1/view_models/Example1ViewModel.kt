package ru.bis.example1.view_models

import android.app.Application
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import ru.bis.example1.R
import ru.bis.example1.ui.adapters.Example1Adapter
import ru.bis.example1_api.interactor.GetDataFromCache
import ru.sir.core.None
import ru.sir.presentation.base.BaseViewModel
import ru.sir.presentation.base.recycler_view.RecyclerViewAdapter
import javax.inject.Inject

class Example1ViewModel @Inject constructor(
    application: Application,
    private val getDataFromCache: GetDataFromCache
    ) : BaseViewModel(application) {

    val result = ObservableField<String>()
    val items = mutableListOf<String>()

    override fun init() {
        getDataFromCache(None()) { it.either(::onLoadDataFromCacheFailed, ::onLoadDataFromCacheSuccess) }

        items.add("String 1")
        items.add("String 2")
        items.add("String 3")
        items.add("String 4")
    }

    private fun onLoadDataFromCacheSuccess(data: String) {
        result.set(data)
    }

    private fun onLoadDataFromCacheFailed(failed: None) {
        result.set(context.getString(R.string.load_data_failed))
    }

    fun recyclerViewAdapter() = RecyclerViewAdapter.Builder(this)
        .addProducer(1, R.layout.item_example1, String::class.java, ItemViewModel::class.java)
        .build()
}