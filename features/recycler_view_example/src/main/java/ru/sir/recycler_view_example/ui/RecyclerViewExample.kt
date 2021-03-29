package ru.sir.recycler_view_example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import ru.sir.presentation.base.BaseApplication
import ru.sir.presentation.base.BaseFragment
import ru.sir.presentation.base.recycler_view.RecyclerViewAdapter
import ru.sir.presentation.extensions.launchWhenStarted
import ru.sir.recycler_view_example.R
import ru.sir.recycler_view_example.databinding.FragmentRecyclerViewExampleBinding
import ru.sir.recycler_view_example.databinding.ItemExample1Binding
import ru.sir.recycler_view_example.databinding.ItemTitleBinding
import ru.sir.recycler_view_example.di.components.RecyclerViewExampleComponent
import ru.sir.recycler_view_example.view_models.ItemViewModel
import ru.sir.recycler_view_example.view_models.RecyclerViewExampleViewModel
import ru.sir.recycler_view_example.view_models.TitleViewModel


class RecyclerViewExample : BaseFragment<RecyclerViewExampleViewModel, FragmentRecyclerViewExampleBinding>(
    RecyclerViewExampleViewModel::class.java) {
    companion object {
        private const val RV_TITLE = 1
        private const val RV_ITEM = 2
    }

    private lateinit var titleBinding: ItemTitleBinding
    private lateinit var itemBinding: ItemExample1Binding

    override fun inject(app: BaseApplication) {
        app.getComponent<RecyclerViewExampleComponent>().inject(this)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentRecyclerViewExampleBinding {
        titleBinding = ItemTitleBinding.inflate(inflater, container, false)
        itemBinding = ItemExample1Binding.inflate(inflater, container, false)
        return FragmentRecyclerViewExampleBinding.inflate(inflater, container, false)
    }

    override fun initVars() {
        binding.rvExample.adapter = recyclerViewAdapter()

        viewModel.isLoading.launchWhenStarted(lifecycleScope) {
            binding.loadingPb.visibility = if (it) View.VISIBLE else View.INVISIBLE
            binding.rvExample.visibility = if (it) View.INVISIBLE else View.VISIBLE
        }
    }

    private fun recyclerViewAdapter() = RecyclerViewAdapter.Builder(viewModel, viewModel.items)
        .addProducer(RV_TITLE, titleBinding, String::class.java, TitleViewModel::class.java)
        .addProducer(RV_ITEM, itemBinding, String::class.java, ItemViewModel::class.java)
        .build()
}