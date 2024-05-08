package com.example.bootckakao.domain.search.model


import com.example.bootckakao.data.model.local.SaveImageDocumentEntity

fun ImageDocumentEntity.toSaveImageDocumentEntity() = SaveImageDocumentEntity(
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





