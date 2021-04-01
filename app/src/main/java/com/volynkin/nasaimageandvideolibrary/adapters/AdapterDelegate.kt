package com.volynkin.nasaimageandvideolibrary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.volynkin.nasaimageandvideolibrary.data.NASAItem
import com.volynkin.nasaimageandvideolibrary.databinding.ItemBinding


class AdapterDelegate(
    private val onItemClick: (title: String, description: String, link: String, type: String) -> Unit,
) :
    AbsListItemAdapterDelegate<NASAItem, NASAItem, AdapterDelegate.ItemHolder>() {

    override fun isForViewType(
        item: NASAItem,
        items: MutableList<NASAItem>,
        position: Int
    ): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): ItemHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)
        return ItemHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(
        item: NASAItem,
        holder: ItemHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class ItemHolder(
        binding: ItemBinding,
        onItemClick: (title: String, description: String, link: String, type: String) -> Unit,
    ) : BaseHolder(binding, onItemClick) {

        fun bind(item: NASAItem) {
            bindMainInfo(
                item.jsonLink, item.preview, item.description,
                item.title, item.date, item.type, item.keywords
            )
        }
    }
}