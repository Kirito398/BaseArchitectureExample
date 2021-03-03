package ru.bis.basearchitectureexample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_example1.*
import ru.bis.basearchitectureexample.App
import ru.bis.basearchitectureexample.R
import ru.bis.example1.di.provides.Example1ComponentProvider
import ru.bis.example1.presentation.interfaces.Example1ViewContract
import ru.sir.core.None

class Example1 : Fragment(), Example1ViewContract.View {
    lateinit var presenter: Example1ViewContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = (App.appContext as Example1ComponentProvider).provideExample1Component().getExample1Presenter()
        lifecycle.addObserver(presenter)
        return inflater.inflate(R.layout.fragment_example1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)
        presenter.init()
    }

    override fun init() {
        //TODO("Not yet implemented")
    }

    override fun setListeners() {
        //TODO("Not yet implemented")
    }

    override fun onLoadDataFromCacheSuccess(data: String) {
        text.text = data
    }

    override fun onLoadDataFromCacheFailed(failed: None) {
        text.text = getString(R.string.load_data_failed)
    }
}