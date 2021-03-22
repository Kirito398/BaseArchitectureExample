package ru.sir.recycler_view_example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.sir.presentation.base.BaseApplication
import ru.sir.presentation.base.BaseFragment
import ru.sir.recycler_view_example.databinding.FragmentRecyclerViewExampleBinding
import ru.sir.recycler_view_example.di.components.RecyclerViewExampleComponent
import ru.sir.recycler_view_example.view_models.RecyclerViewExampleViewModel


class RecyclerViewExample : BaseFragment<RecyclerViewExampleViewModel, FragmentRecyclerViewExampleBinding>(
    RecyclerViewExampleViewModel::class.java) {
    override fun inject(app: BaseApplication) {
        app.getComponent<RecyclerViewExampleComponent>().inject(this)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentRecyclerViewExampleBinding.inflate(inflater, container, false).apply {
        viewModel = this@RecyclerViewExample.viewModel
    }
}