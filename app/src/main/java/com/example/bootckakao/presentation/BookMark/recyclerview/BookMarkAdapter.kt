package com.example.bootckakao.presentation.search.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.bootckakao.domain.search.model.ImageDocumentEntity

class BookMarkAdapter(
    private val bookMarkClickListener: BookMarkClickListener
) : ListAdapter<ImageDocumentEntity, BookMarkViewHolder>(BookMarkDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookMarkViewHolder = BookMarkViewHolder(parent = parent)

    override fun onBindViewHolder(holder: BookMarkViewHolder, position: Int) {
        holder.bind(getItem(position), bookMarkClickListener)
    }
}
