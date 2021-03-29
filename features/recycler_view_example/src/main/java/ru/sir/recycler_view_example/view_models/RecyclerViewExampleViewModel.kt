package ru.sir.recycler_view_example.view_models

import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.sir.core.None
import ru.sir.presentation.base.BaseViewModel
import ru.sir.presentation.base.recycler_view.RecyclerViewBaseDataModel
import ru.sir.presentation.extensions.launchOn
import ru.sir.recycler_view_example_api.interactor.LoadData
import ru.sir.recycler_view_example_api.models.Item
import javax.inject.Inject

class RecyclerViewExampleViewModel @Inject constructor(
    application: Application,
    private val loadData: LoadData
) : BaseViewModel(application) {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _items = MutableStateFlow<List<RecyclerViewBaseDataModel>>(emptyList())
    var items = _items.asStateFlow()

    override fun init() {
        _isLoading.value = true
        loadData(None()).launchOn(viewModelScope) { it.either({}, ::onDataLoaded) }
    }

    private fun onDataLoaded(data: List<Item>) {
        _items.value = data.toRecyclerViewItems()
        _isLoading.value = false
    }

    private fun List<Item>.toRecyclerViewItems(): List<RecyclerViewBaseDataModel> {
        val newList = mutableListOf<RecyclerViewBaseDataModel>()
        this.forEach { newList.add(RecyclerViewBaseDataModel(it.name, it.type)) }
        return newList
    }
}