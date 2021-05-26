package ru.bis.example2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_example2.*
import ru.bis.example2.databinding.FragmentExample2Binding
import ru.bis.example2.di.components.Example2Component
import ru.bis.example2.view_models.Example2ViewModel
import ru.sir.presentation.base.BaseApplication
import ru.sir.presentation.base.BaseFragment
import ru.sir.presentation.extensions.launchWhenStarted

class Example2 : BaseFragment<Example2ViewModel, FragmentExample2Binding>(Example2ViewModel::class.java) {

    override fun inject(app: BaseApplication) {
        app.getComponent<Example2Component>().inject(this)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentExample2Binding.inflate(inflater, container, false)

    override fun initVars() {
        viewModel.isLoading.launchWhenStarted(lifecycleScope) {
            binding.pbLoading.visibility = if (it) View.VISIBLE else View.INVISIBLE
            binding.text.visibility = if (it) View.INVISIBLE else View.VISIBLE
        }

        viewModel.text.launchWhenStarted(lifecycleScope) {
            binding.text.text = it
        }
    }

    override fun setListeners() {
        //TODO("Not yet implemented")
    }
}