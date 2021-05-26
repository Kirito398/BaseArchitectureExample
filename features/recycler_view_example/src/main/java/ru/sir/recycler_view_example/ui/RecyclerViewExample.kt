package ru.sir.recycler_view_example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import ru.sir.presentation.base.BaseApplication
import ru.sir.presentation.base.BaseFragment
import ru.sir.presentation.base.recycler_view.RecyclerViewAdapter
import ru.sir.presentation.extensions.launchWhenStarted
import ru.sir.recycler_view_example.databinding.FragmentRecyclerViewExampleBinding
import ru.sir.recycler_view_example.di.components.RecyclerViewExampleComponent
import ru.sir.recycler_view_example.ui.producers.ItemViewHolderProducer
import ru.sir.recycler_view_example.ui.producers.TitleViewHolderProducer
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
    ) = FragmentRecyclerViewExampleBinding.inflate(inflater, container, false)

    override fun initVars() {
        binding.rvExample.adapter = recyclerViewAdapter()

        viewModel.isLoading.launchWhenStarted(lifecycleScope) {
            binding.loadingPb.visibility = if (it) View.VISIBLE else View.INVISIBLE
            binding.rvExample.visibility = if (it) View.INVISIBLE else View.VISIBLE
        }
    }

    private fun recyclerViewAdapter() = RecyclerViewAdapter.Builder(this, viewModel.items)
        .addProducer(TitleViewHolderProducer())
        .addProducer(ItemViewHolderProducer())
        .build(viewModel::toRecyclerViewItems)
}