package ru.sir.presentation.base.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import ru.sir.presentation.base.BaseViewModel

class ViewHolderProducer<M : Any, I : RecyclerViewBaseItem<M, VM>, VM : BaseViewModel>(val type: Int, @LayoutRes val layoutId: Int, val modelClassType: Class<M>, private val itemViewModelClassType: Class<I>) {
    private lateinit var parentViewModel: VM
    private var viewModelId: Int = -1

    fun setParentViewModel(viewModel: VM) {
        parentViewModel = viewModel
    }

    fun setViewModelId(id: Int) {
        viewModelId = id
    }

    fun getViewType() = type

    fun produce(parent: ViewGroup): BaseViewHolder<M, I> {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )

        return BaseViewHolder(binding, instantiateViewModel(), viewModelId)
    }

    private fun instantiateViewModel(): I {
        val viewModelClass = itemViewModelClassType.newInstance()
        viewModelClass.init(parentViewModel)
        return viewModelClass
    }
}