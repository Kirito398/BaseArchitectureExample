package ru.bis.example1.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import ru.bis.example1.databinding.FragmentExample1Binding
import ru.bis.example1.di.components.Example1Component
import ru.bis.example1.ui.fragments.NavActions.OPEN_EXAMPLE_2
import ru.bis.example1.view_models.Example1ViewModel
import ru.sir.presentation.base.BaseApplication
import ru.sir.presentation.base.BaseFragment
import ru.sir.presentation.extensions.launchWhenStarted
import ru.sir.presentation.navigation.UiAction

class Example1 : BaseFragment<Example1ViewModel, FragmentExample1Binding>(Example1ViewModel::class.java) {
    override fun inject(app: BaseApplication) {
        app.getComponent<Example1Component>().inject(this)
    }

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentExample1Binding.inflate(inflater, container, false)

    override fun initVars() {
        viewModel.result.launchWhenStarted(lifecycleScope) {
            binding.text.text = it
        }
    }

    override fun setListeners() {
        binding.nextBtn.setOnClickListener {
            navigator.navigateTo(UiAction(OPEN_EXAMPLE_2))
        }
    }
}