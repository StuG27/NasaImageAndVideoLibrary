package com.volynkin.nasaimageandvideolibrary.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.volynkin.nasaimageandvideolibrary.R
import com.volynkin.nasaimageandvideolibrary.databinding.ItemBinding


abstract class BaseHolder(
    binding: ItemBinding,
    onItemClick: (title: String, description: String, link: String, type: String) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private var title: String? = null
    private var description: String? = null
    private var jsonLink: String? = null
    private var type: String? = null

    init {
        binding.root.setOnClickListener {
            onItemClick(
                title ?: "", description ?: "",
                jsonLink ?: "", type ?: ""
            )
        }
    }

    private val iVPreview = binding.iVPreview
    private val tVTitle = binding.tVTitle
    private val tVDate = binding.tVDate
    private val tVKeywords = binding.tVKeywords
    private val tVType = binding.tVType

    protected fun bindMainInfo(
        jsonLink: String,
        preview: String,
        description: String,
        title: String,
        date: String,
        type: String,
        keywords: String
    ) {
        this.title = title
        this.description = description
        this.jsonLink = jsonLink
        this.type = type
        if (title.length > 50) {
            tVTitle.text = title.substring(0, 50).plus("...")
        } else {
            tVTitle.text = title
        }
        Glide
            .with(itemView)
            .load(preview)
            .placeholder(R.drawable.ic_twotone_photo_24)
            .error(R.drawable.ic_baseline_error_24)
            .into(iVPreview)
        tVDate.text = date.substring(0, 10)
        if (keywords.isEmpty()) {
            tVKeywords.text = ""
        } else {
            tVKeywords.text = keywords
        }
        tVType.text = type
    }
}