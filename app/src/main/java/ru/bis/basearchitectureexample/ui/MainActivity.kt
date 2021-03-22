package ru.bis.basearchitectureexample.ui

import androidx.navigation.findNavController
import ru.bis.basearchitectureexample.R
import ru.bis.example1.ui.fragments.Example1
import ru.sir.presentation.base.BaseActivity
import ru.sir.presentation.navigation.UiAction

class MainActivity : BaseActivity() {
    override val layoutId: Int = R.layout.activity_main
    override fun getNavController() = findNavController(R.id.navHostFragment)

    override fun navigateTo(action: UiAction) {
        when(action.action) {
            Example1.ACTION_OPEN_EXAMPLE_2 -> { navigator.navigate(R.id.example2) }
        }
    }
}