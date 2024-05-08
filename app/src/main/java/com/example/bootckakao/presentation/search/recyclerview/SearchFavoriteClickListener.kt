package com.example.bootckakao.presentation.search.recyclerview

import android.widget.CompoundButton
import com.example.bootckakao.domain.search.model.ImageDocumentEntity

interface SearchFavoriteClickListener {
    fun onFavoriteItemClick(
        compoundButton: CompoundButton,
        b: Boolean,
        position: Int,
        item: ImageDocumentEntity
    )
}