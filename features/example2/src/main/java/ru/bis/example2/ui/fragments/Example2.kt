package ru.bis.example2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_example2.*
import ru.bis.example2.databinding.FragmentExample2Binding
import ru.bis.example2.di.components.Example2Component
import ru.bis.example2.view_models.Example2ViewModel
import ru.sir.presentation.base.BaseApplication
import ru.sir.presentation.base.BaseFragment

class Example2 : BaseFragment<Example2ViewModel, FragmentExample2Binding>(Example2ViewModel::class.java) {

    override fun inject(app: BaseApplication) {
        app.getComponent<Example2Component>().inject(this)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentExample2Binding.inflate(inflater, container, false).apply {
        viewModel = this@Example2.viewModel
    }

    override fun setListeners() {
        //TODO("Not yet implemented")
    }
}