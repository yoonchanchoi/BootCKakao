package com.example.bootckakao.domain.search.model

data class ImageDocument(
    val collection: String = "",
    val thumbnailUrl: String = "",
    val imageUrl: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val displaySitename: String = "",
    val docUrl: String = "",
    val datetime: String = "",
    val favorite: Boolean = false
)