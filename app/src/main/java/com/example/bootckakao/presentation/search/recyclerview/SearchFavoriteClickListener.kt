package com.example.bootckakao.presentation.search.recyclerview

import com.example.bootckakao.domain.search.model.ImageDocument

interface SearchFavoriteClickListener {
    fun onFavoriteItemClick(
        position: Int,
        item: ImageDocument
    )
}