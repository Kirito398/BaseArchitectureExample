package ru.sir.presentation.base.recycler_view

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.StateFlow
import ru.sir.presentation.base.BaseViewModel

class RecyclerViewAdapter(private val producers: SparseArray<ViewHolderProducer<in Any, *, *, *>>, private val data: StateFlow<List<RecyclerViewBaseDataModel>>)
    : RecyclerView.Adapter<BaseViewHolder<in Any, *, *>>() {

    class Builder<VM : BaseViewModel>(private val viewModel: VM, private val dataFlow: StateFlow<List<RecyclerViewBaseDataModel>>) {
        private val producers = SparseArray<ViewHolderProducer<*, *, *, *>>()

        fun <M : Any, I : RecyclerViewBaseItem<M, VM, B>, B : ViewBinding> addProducer(
            type: Int,
            binding: B,
            modelClassType: Class<M>,
            itemViewModelClassType: Class<I>
        ): Builder<VM> {
            val producer: ViewHolderProducer<M, I, VM, B> = ViewHolderProducer(type, binding, modelClassType, itemViewModelClassType)
            return addProducer(producer)
        }

        fun <M : Any, I : RecyclerViewBaseItem<M, VM, B>, B : ViewBinding> addProducer(producer: ViewHolderProducer<M, I, VM, B>): Builder<VM> {
            producer.setParentViewModel(viewModel)
            producers.put(producer.getViewType(), producer)
            return this
        }

        @Suppress("UNCHECKED_CAST")
        fun build() = RecyclerViewAdapter(producers as SparseArray<ViewHolderProducer<in Any, *, *, *>>, dataFlow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<in Any, *, *> {
        return producers[viewType]?.produce(parent)
            ?: throw IllegalStateException("View Holder Producer not found!")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<in Any, *, *>, position: Int) {
        holder.bindData(data.value[position].getData())
    }

    override fun getItemCount(): Int = data.value.size

    override fun getItemViewType(position: Int): Int {
        return data.value[position].getType()
    }
}