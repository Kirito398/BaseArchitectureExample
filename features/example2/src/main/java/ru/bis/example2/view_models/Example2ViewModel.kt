package ru.bis.example2.view_models

import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.bis.example2.R
import ru.bis.example2_api.interactor.GetDataFromServer
import ru.bis.example2_api.type.Failure
import ru.sir.presentation.base.BaseViewModel
import ru.sir.presentation.extensions.launchOn
import javax.inject.Inject

class Example2ViewModel @Inject constructor(
    application: Application,
    private val getDataFromServer: GetDataFromServer
) : BaseViewModel(application) {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _text = MutableStateFlow(context.getString(R.string.data_text))
    val text = _text.asStateFlow()

    override fun init() {
        loadData()
    }

    private fun loadData() {
        _isLoading.value = true

        getDataFromServer(GetDataFromServer.Params("Kadzuto", "Kirigaya"))
            .launchOn(viewModelScope) {
                it.either(::onLoadDataFailed, ::onLoadDataSuccess)
                _isLoading.value = false
            }
    }

    private fun onLoadDataSuccess(data: String) {
        _text.value = data
    }

    private fun onLoadDataFailed(failure: Failure) {
        when (failure) {
            Failure.NetworkConnectionError -> TODO()
            Failure.ServerError -> TODO()
            Failure.ServerNotFoundError -> TODO()
            Failure.AuthorizationError -> TODO()
            Failure.AccountNotFoundError -> TODO()
            Failure.UnknownError -> TODO()
        }
    }
}