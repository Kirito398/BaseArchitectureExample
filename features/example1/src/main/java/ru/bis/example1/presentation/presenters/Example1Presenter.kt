package ru.bis.example1.presentation.presenters

import ru.bis.entities.None
import ru.bis.example1.presentation.interfaces.Example1ViewContract
import ru.bis.example1_api.interactor.GetDataFromCache

internal class Example1Presenter(
    private val getDataFromCache: GetDataFromCache
) : Example1ViewContract.Presenter {
    private lateinit var view: Example1ViewContract.View

    override fun setView(view: Example1ViewContract.View) {
        this.view = view
    }

    override fun init() {
        view.init()
        view.setListeners()

        getDataFromCache(None()) {
            it.either(view::onLoadDataFromCacheFailed, view::onLoadDataFromCacheSuccess)
        }
    }
}