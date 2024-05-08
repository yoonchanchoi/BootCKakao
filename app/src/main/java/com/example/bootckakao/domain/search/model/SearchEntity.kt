package com.example.bootckakao.domain.search.model

data class SearchEntity(
    val meta: MetaEntity? = null,
    val documents: List<ImageDocumentEntity>? = null
)
