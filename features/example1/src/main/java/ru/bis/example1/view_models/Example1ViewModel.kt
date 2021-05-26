package ru.bis.example1.view_models

import android.app.Application
import kotlinx.coroutines.flow.*
import ru.bis.example1.R
import ru.bis.example1_api.interactor.GetDataFromCache
import ru.sir.core.None
import ru.sir.presentation.base.BaseViewModel
import javax.inject.Inject

class Example1ViewModel @Inject constructor(
    application: Application,
    private val getDataFromCache: GetDataFromCache
    ) : BaseViewModel(application) {

    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result.asStateFlow()

    override fun init() {
        getDataFromCache(None()) { it.either(::onLoadDataFromCacheFailed, ::onLoadDataFromCacheSuccess) }
    }

    private fun onLoadDataFromCacheSuccess(data: String) {
        _result.value = data
    }

    private fun onLoadDataFromCacheFailed(failed: None) {
        _result.value = context.getString(R.string.load_data_failed)
    }
}