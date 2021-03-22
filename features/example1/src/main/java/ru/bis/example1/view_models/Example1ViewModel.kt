package ru.bis.example1.view_models

import android.app.Application
import androidx.databinding.ObservableField
import ru.bis.example1.R
import ru.bis.example1_api.interactor.GetDataFromCache
import ru.sir.core.None
import ru.sir.presentation.base.BaseViewModel
import javax.inject.Inject

class Example1ViewModel @Inject constructor(
    application: Application,
    private val getDataFromCache: GetDataFromCache
    ) : BaseViewModel(application) {

    val result = ObservableField<String>()

    override fun init() {
        getDataFromCache(None()) { it.either(::onLoadDataFromCacheFailed, ::onLoadDataFromCacheSuccess) }
    }

    private fun onLoadDataFromCacheSuccess(data: String) {
        result.set(data)
    }

    private fun onLoadDataFromCacheFailed(failed: None) {
        result.set(context.getString(R.string.load_data_failed))
    }
}