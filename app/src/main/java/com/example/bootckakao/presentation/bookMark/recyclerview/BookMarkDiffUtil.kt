package com.example.bootckakao.presentation.search.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.bootckakao.domain.search.model.ImageDocument

class BookMarkDiffUtil : DiffUtil.ItemCallback<ImageDocument>() {

    override fun areItemsTheSame(oldItem: ImageDocument, newItem: ImageDocument): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: ImageDocument, newItem: ImageDocument): Boolean =
        oldItem == newItem
}
