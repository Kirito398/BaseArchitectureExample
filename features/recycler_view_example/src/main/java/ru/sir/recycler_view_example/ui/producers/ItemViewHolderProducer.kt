package ru.sir.recycler_view_example.ui.producers

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.sir.presentation.base.recycler_view.ViewHolderProducer
import ru.sir.recycler_view_example.databinding.ItemExample1Binding
import ru.sir.recycler_view_example.ui.producers.ItemType.RV_ITEM
import ru.sir.recycler_view_example.view_models.ItemViewModel

class ItemViewHolderProducer : ViewHolderProducer<String, ItemViewModel, ItemExample1Binding> (RV_ITEM, String::class.java, ItemViewModel::class.java) {
    override fun initBinding(inflater: LayoutInflater, parent: ViewGroup) =
        ItemExample1Binding.inflate(inflater, parent, false)
}