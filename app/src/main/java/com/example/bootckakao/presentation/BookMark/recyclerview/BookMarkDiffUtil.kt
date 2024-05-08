package com.example.bootckakao.presentation.search.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.bootckakao.domain.search.model.ImageDocumentEntity

class BookMarkDiffUtil : DiffUtil.ItemCallback<ImageDocumentEntity>() {

    override fun areItemsTheSame(oldItem: ImageDocumentEntity, newItem: ImageDocumentEntity): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: ImageDocumentEntity, newItem: ImageDocumentEntity): Boolean =
        oldItem == newItem
}
