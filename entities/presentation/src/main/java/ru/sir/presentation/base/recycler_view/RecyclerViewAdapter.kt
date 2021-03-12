package ru.sir.presentation.base.recycler_view

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import ru.sir.presentation.base.BaseViewModel
import java.lang.IllegalStateException

class RecyclerViewAdapter(private val producers: MutableMap<Int, ViewHolderProducer<*, *, *>>) : RecyclerView.Adapter<BaseViewHolder>() {

    private var data = mutableListOf<String>()

    class Builder<VM : BaseViewModel>(private val viewModel: VM) {
        private val producers = mutableMapOf<Int, ViewHolderProducer<*, *, *>>()

        fun <M, I : RecyclerViewBaseItem<M, VM>> addProducer(type: Int, @LayoutRes layoutId: Int, modelClassType: Class<M>, itemViewModelClassType: Class<I>): Builder<VM> {
            val producer: ViewHolderProducer<M, I, VM> = ViewHolderProducer(type, layoutId, modelClassType, itemViewModelClassType)
            return addProducer(producer)
        }

        fun <M, I : RecyclerViewBaseItem<M, VM>> addProducer(producer: ViewHolderProducer<M, I, VM>): Builder<VM> {
            producer.setParentViewModel(viewModel)
            producers[producer.getViewType()] = producer
            return this
        }

        fun build() = RecyclerViewAdapter(producers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        return producers[viewType]?.produce(parent)
            ?: throw IllegalStateException("View Holder Producer not found!")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*, *>, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int = data.size
}