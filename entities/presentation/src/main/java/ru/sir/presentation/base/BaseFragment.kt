package ru.sir.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseFragment<T : BaseViewModel, B : ViewBinding>(private val type: Class<out T>) : Fragment() {
    protected lateinit var viewModel: T
    protected lateinit var binding: B
    protected lateinit var navigator: BaseActivity

    private lateinit var onBackPressedCallback: OnBackPressedCallback

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

        navigator = requireActivity() as BaseActivity

        initOnBackPressedCallback()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVars()
        setListeners()
    }

    private fun initOnBackPressedCallback() {
        onBackPressedCallback = object : OnBackPressedCallback(false) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(onBackPressedCallback)
    }

    fun setBackPressedEnable(enable: Boolean) {
        onBackPressedCallback.isEnabled = enable
    }

    protected fun hideKeyBoard() {
        activity?.currentFocus?.let { view ->
            val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun provideViewModel(): T = ViewModelProvider(this, viewModelFactory)[type]

    protected abstract fun inject(app: BaseApplication)
    protected abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): B
    protected open fun onBackPressed() = Unit
    protected open fun initVars() = Unit
    protected open fun setListeners() = Unit
}