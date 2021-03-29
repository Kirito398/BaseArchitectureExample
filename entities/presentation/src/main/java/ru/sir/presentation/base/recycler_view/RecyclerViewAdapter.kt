package ru.sir.presentation.base.recycler_view

import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.StateFlow
import ru.sir.presentation.extensions.launchWhenStarted

class RecyclerViewAdapter(private val producers: SparseArray<ViewHolderProducer<in Any, *, *>>,
                          private val data: StateFlow<List<RecyclerViewBaseDataModel>>,
                          parent: Fragment) : RecyclerView.Adapter<BaseViewHolder<in Any, *, *>>() {

    init {
        data.launchWhenStarted(parent.lifecycleScope) {
            notifyDataSetChanged()
        }
    }

    class Builder<VM : Fragment>(private val parent: VM, private val dataFlow: StateFlow<List<RecyclerViewBaseDataModel>>) {
        private val producers = SparseArray<ViewHolderProducer<*, *, *>>()

        fun <M : Any, I : RecyclerViewBaseItem<M, B>, B : ViewBinding> addProducer(producer: ViewHolderProducer<M, I, B>): Builder<VM> {
            producer.setParent(parent)
            producers.put(producer.getViewType(), producer)
            return this
        }

        @Suppress("UNCHECKED_CAST")
        fun build() = RecyclerViewAdapter(producers as SparseArray<ViewHolderProducer<in Any, *, *>>, dataFlow, parent)
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