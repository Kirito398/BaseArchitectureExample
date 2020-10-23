package ru.bis.example2.presentation.presenters

import ru.bis.example2.presentation.interfaces.Example2ViewContract
import ru.bis.example2_api.interactor.GetDataFromServer
import ru.bis.example2_api.type.Failure

internal class Example2Presenter(
    private val getDataFromServer: GetDataFromServer
) : Example2ViewContract.Presenter {
    private lateinit var view: Example2ViewContract.View

    override fun setView(view: Example2ViewContract.View) {
        this.view = view
    }

    override fun init() {
        view.init()
        view.setListeners()

        loadData()
    }

    private fun loadData() {
        view.showProgressBar()

        getDataFromServer(GetDataFromServer.Params("Kadzuto", "Kirigaya")) {
            it.either(::onLoadDataFailed, ::onLoadDataSuccess)
        }
    }

    private fun onLoadDataSuccess(data: String) {
        view.setText(data)
        view.hideProgressBar()
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