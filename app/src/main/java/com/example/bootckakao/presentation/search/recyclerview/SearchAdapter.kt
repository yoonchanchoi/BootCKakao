package com.example.bootckakao.presentation.search.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.bootckakao.domain.search.model.ImageDocumentEntity

class SearchAdapter(
    private val searchFavoriteClickListener: SearchFavoriteClickListener
) : ListAdapter<ImageDocumentEntity, SearchViewHolder>(SearchDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder = SearchViewHolder(parent = parent)

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position), searchFavoriteClickListener)
    }
}