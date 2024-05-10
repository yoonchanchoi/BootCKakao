package com.example.bootckakao.data.model.remote


import com.example.bootckakao.domain.search.model.ImageDocument
import com.example.bootckakao.domain.search.model.Meta

fun MetaResponse.toMeta() = Meta(
    totalCount = totalCount,
    pageableCount = pageableCount,
    isEnd = isEnd,
)

fun ImageDocumentResponse.toImageDocument(favorite: Boolean) = ImageDocument(
    collection = collection,
    thumbnailUrl = thumbnailUrl,
    imageUrl = imageUrl,
    width = width,
    height = height,
    displaySitename = displaySitename,
    docUrl = docUrl,
    datetime = datetime.toChangeDate(),
    favorite = favorite
)





