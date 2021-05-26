package ru.sir.presentation.base.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class ViewHolderProducer<M : Any, I : RecyclerViewBaseItem<M, B>, B : ViewBinding>
    (val type: Int, val modelClassType: Class<M>, private val itemViewModelClassType: Class<I>) {

    private lateinit var parent: Fragment

    fun setParent(parent: Fragment) {
        this.parent = parent
    }

    fun getViewType() = type

    abstract fun initBinding(inflater: LayoutInflater, parent: ViewGroup): B

    fun produce(parent: ViewGroup): BaseViewHolder<M, I, B> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = initBinding(inflater, parent)
        return BaseViewHolder(binding, instantiateViewModel(binding))
    }

    private fun instantiateViewModel(binding: B): I {
        val viewModelClass = itemViewModelClassType.newInstance()
        viewModelClass.init(parent, binding)
        return viewModelClass
    }
}