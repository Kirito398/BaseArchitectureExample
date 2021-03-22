package ru.sir.presentation.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import ru.sir.presentation.navigation.UiAction

abstract class BaseActivity : AppCompatActivity() {
    abstract val layoutId: Int
    protected lateinit var navigator: NavController

    abstract fun getNavController(): NavController
    abstract fun navigateTo(action: UiAction)
    protected open fun onActivityCreated() = Unit

    fun navigateTo(action: String, bundle: Bundle? = null) {
        navigateTo(UiAction(action, bundle))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        navigator = getNavController()
        onActivityCreated()
    }
}