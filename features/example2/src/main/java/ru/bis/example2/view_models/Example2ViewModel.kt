package ru.bis.example2.view_models

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import ru.bis.example2.R
import ru.bis.example2_api.interactor.GetDataFromServer
import ru.bis.example2_api.type.Failure
import ru.sir.presentation.base.BaseViewModel
import javax.inject.Inject

class Example2ViewModel @Inject constructor(
    application: Application,
    private val getDataFromServer: GetDataFromServer
) : BaseViewModel(application) {

    val isLoading = ObservableBoolean(false)
    val text = ObservableField(context.getString(R.string.data_text))

    override fun init() {
        loadData()
    }

    private fun loadData() {
        isLoading.set(true)

        getDataFromServer(GetDataFromServer.Params("Kadzuto", "Kirigaya")) {
            it.either(::onLoadDataFailed, ::onLoadDataSuccess)
            isLoading.set(false)
        }
    }

    private fun onLoadDataSuccess(data: String) {
        text.set(data)
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