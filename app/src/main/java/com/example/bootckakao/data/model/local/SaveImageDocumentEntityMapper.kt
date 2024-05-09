package com.example.bootckakao.data.model.local


import com.example.bootckakao.domain.search.model.ImageDocument

fun SaveImageDocumentEntity.toImageDocumentEntity() = ImageDocument(
    collection = collection,
    thumbnailUrl = thumbnailUrl,
    imageUrl = imageUrl,
    width = width,
    height = height,
    displaySitename = displaySitename,
    docUrl = docUrl,
    datetime = datetime,
    favorite = favorite
)


