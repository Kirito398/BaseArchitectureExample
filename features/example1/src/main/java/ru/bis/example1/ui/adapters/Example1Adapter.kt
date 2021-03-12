package ru.bis.example1.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.bis.example1.R
import ru.bis.example1.databinding.ItemExample1Binding

class Example1Adapter(private val items: MutableList<String>): RecyclerView.Adapter<Example1ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Example1ViewHolder {
        val binding = DataBindingUtil.inflate<ItemExample1Binding>(
            LayoutInflater.from(parent.context),
            R.layout.item_example1,
            parent,
            false
        )

        return Example1ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Example1ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}