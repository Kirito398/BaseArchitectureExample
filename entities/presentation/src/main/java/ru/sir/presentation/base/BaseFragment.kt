package ru.sir.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseFragment<T : BaseViewModel, B : ViewBinding>(private val type: Class<out T>) : Fragment() {
    protected lateinit var viewModel: T
    protected lateinit var binding: B

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject(activity?.application as BaseApplication)
        viewModel = provideViewModel()
        lifecycle.addObserver(viewModel)

        binding = initBinding(inflater, container, savedInstanceState)
        viewModel.init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun provideViewModel(): T = ViewModelProviders.of(this, viewModelFactory)[type]

    protected abstract fun inject(app: BaseApplication)
    protected abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): B
    protected open fun setListeners() = Unit
}