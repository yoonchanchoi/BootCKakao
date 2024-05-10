package com.example.bootckakao.data.model.remote


import com.example.bootckakao.data.model.local.SaveImageDocumentEntity
import com.example.bootckakao.domain.search.model.ImageDocument

fun ImageDocument.toEntity() = SaveImageDocumentEntity(
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





