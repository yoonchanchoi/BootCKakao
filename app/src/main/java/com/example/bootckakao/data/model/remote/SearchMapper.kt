package com.example.bootckakao.data.model.remote


import com.example.bootckakao.domain.search.model.ImageDocumentEntity
import com.example.bootckakao.domain.search.model.MetaEntity
import com.example.bootckakao.domain.search.model.SearchEntity

fun SearchResponse.toEntity() = SearchEntity(
    meta = meta?.toEntity(),
    documents = documents?.map {
        it.toEntity()
    }
)

fun MetaResponse.toEntity() = MetaEntity(
    totalCount = totalCount,
    pageableCount = pageableCount,
    isEnd = isEnd,
)

fun ImageDocumentResponse.toEntity() = ImageDocumentEntity(
    collection = collection,
    thumbnailUrl = thumbnailUrl,
    imageUrl = imageUrl,
    width = width,
    height = height,
    displaySitename = displaySitename,
    docUrl = docUrl,
    datetime = datetime.toChangeDate(),
    favorite = false
)





