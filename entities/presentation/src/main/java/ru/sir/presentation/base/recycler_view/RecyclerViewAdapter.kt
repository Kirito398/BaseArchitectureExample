package ru.sir.presentation.base.recycler_view

import android.util.SparseArray
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import ru.sir.presentation.base.BaseViewModel

class RecyclerViewAdapter(private val producers: SparseArray<ViewHolderProducer<in Any, *, *>>, private val data: MutableList<RecyclerViewBaseDataModel>) : RecyclerView.Adapter<BaseViewHolder<in Any, *>>() {

    class Builder<VM : BaseViewModel>(private val viewModel: VM, private val viewModelId: Int) {
        private val producers = SparseArray<ViewHolderProducer<*, *, *>>()

        fun <M : Any, I : RecyclerViewBaseItem<M, VM>> addProducer(
            type: Int,
            @LayoutRes layoutId: Int,
            modelClassType: Class<M>,
            itemViewModelClassType: Class<I>
        ): Builder<VM> {
            val producer: ViewHolderProducer<M, I, VM> = ViewHolderProducer(type, layoutId, modelClassType, itemViewModelClassType)
            return addProducer(producer)
        }

        fun <M : Any, I : RecyclerViewBaseItem<M, VM>> addProducer(producer: ViewHolderProducer<M, I, VM>): Builder<VM> {
            producer.setParentViewModel(viewModel)
            producer.setViewModelId(viewModelId)
            producers.put(producer.getViewType(), producer)
            return this
        }

        @Suppress("UNCHECKED_CAST")
        fun build(data: MutableList<RecyclerViewBaseDataModel>) = RecyclerViewAdapter(producers as SparseArray<ViewHolderProducer<in Any, *, *>>, data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<in Any, *> {
        return producers[viewType]?.produce(parent)
            ?: throw IllegalStateException("View Holder Producer not found!")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<in Any, *>, position: Int) {
        holder.bindData(data[position].getData())
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        return data[position].getType()
    }
}