package ru.bis.basearchitectureexample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_example2.*
import ru.bis.basearchitectureexample.App
import ru.bis.basearchitectureexample.R
import ru.bis.example2.di.provides.Example2ComponentProvider
import ru.bis.example2.presentation.interfaces.Example2ViewContract

class Example2 : Fragment(), Example2ViewContract.View {
    private lateinit var presenter: Example2ViewContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = (App.appContext as Example2ComponentProvider).provideExample2Component().getExample2Presenter()
        lifecycle.addObserver(presenter)
        return inflater.inflate(R.layout.fragment_example2, container, false)
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

    override fun showProgressBar() {
        pbLoading.visibility = View.VISIBLE
        text.visibility = View.INVISIBLE
    }

    override fun hideProgressBar() {
        pbLoading.visibility = View.GONE
        text.visibility = View.VISIBLE
    }

    override fun setText(text: String) {
        this.text.text = text
    }
}