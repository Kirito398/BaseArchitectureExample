package ru.sir.presentation.base.recycler_view

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import ru.sir.presentation.base.BaseViewModel

class ViewHolderProducer<M : Any, I : RecyclerViewBaseItem<M, VM, B>, VM : BaseViewModel, B : ViewBinding>
    (val type: Int, val binding: B, val modelClassType: Class<M>, private val itemViewModelClassType: Class<I>) {

    private lateinit var parentViewModel: VM

    fun setParentViewModel(viewModel: VM) {
        parentViewModel = viewModel
    }

    fun getViewType() = type

    fun produce(parent: ViewGroup): BaseViewHolder<M, I, B> {
        return BaseViewHolder(binding, instantiateViewModel())
    }

    private fun instantiateViewModel(): I {
        val viewModelClass = itemViewModelClassType.newInstance()
        viewModelClass.init(parentViewModel, binding)
        return viewModelClass
    }
}