package com.example.bootckakao.presentation.search.recyclerview

import com.example.bootckakao.domain.search.model.ImageDocument

interface BookMarkClickListener {
    fun onItemLongeClick(
        position: Int,
        item: ImageDocument
    ): Boolean
}