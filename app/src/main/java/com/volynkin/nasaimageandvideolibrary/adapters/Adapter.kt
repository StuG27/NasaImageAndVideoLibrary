package com.volynkin.nasaimageandvideolibrary.adapters

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.volynkin.nasaimageandvideolibrary.data.NASAItem


class Adapter(
    onItemClick: (title: String, description: String, link: String, type: String) -> Unit,
) : AsyncListDifferDelegationAdapter<NASAItem>(PersonDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(AdapterDelegate(onItemClick))
    }

    class PersonDiffUtilCallback : DiffUtil.ItemCallback<NASAItem>() {

        override fun areItemsTheSame(oldItem: NASAItem, newItem: NASAItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NASAItem, newItem: NASAItem): Boolean {
            return oldItem == newItem
        }
    }
}