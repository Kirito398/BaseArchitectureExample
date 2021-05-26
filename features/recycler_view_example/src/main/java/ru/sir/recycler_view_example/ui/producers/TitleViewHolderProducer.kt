package ru.sir.recycler_view_example.ui.producers

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.sir.presentation.base.recycler_view.ViewHolderProducer
import ru.sir.recycler_view_example.databinding.ItemTitleBinding
import ru.sir.recycler_view_example.ui.producers.ItemType.RV_TITLE
import ru.sir.recycler_view_example.view_models.TitleViewModel

class TitleViewHolderProducer : ViewHolderProducer<String, TitleViewModel, ItemTitleBinding>(
    RV_TITLE, String::class.java, TitleViewModel::class.java) {

    override fun initBinding(inflater: LayoutInflater, parent: ViewGroup): ItemTitleBinding =
        ItemTitleBinding.inflate(inflater, parent, false)
}