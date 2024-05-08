package com.example.bootckakao.presentation.search.recyclerview

import com.example.bootckakao.domain.search.model.ImageDocumentEntity

interface BookMarkClickListener {
    fun onItemLongeClick(
        position: Int,
        item: ImageDocumentEntity
    ): Boolean
}