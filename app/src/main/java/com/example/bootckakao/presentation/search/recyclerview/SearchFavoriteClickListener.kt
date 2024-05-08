package com.example.bootckakao.presentation.search.recyclerview

import android.widget.CompoundButton
import com.example.bootckakao.domain.search.model.ImageDocumentEntity

interface SearchFavoriteClickListener {
    fun onFavoriteItemClick(
        position: Int,
        item: ImageDocumentEntity
    )
}