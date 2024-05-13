package com.example.bootckakao.presentation.search

import com.example.bootckakao.domain.search.model.ImageDocument

fun ImageDocument.toChangeImageDocument(favorite: Boolean) = ImageDocument(
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

