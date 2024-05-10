package com.example.bootckakao.domain.search.repository

import com.example.bootckakao.data.model.local.SaveImageDocumentEntity
import com.example.bootckakao.domain.search.model.ImageDocument

interface DefaultSearchRepository {

    //일반 api
    suspend fun requestSearch(query: String): List<ImageDocument>

    suspend fun addSaveImageDocumentEntity(imageDocument: ImageDocument)

    suspend fun deleteSaveImageDocumentEntity(imageUrl: String)

    suspend fun getAllSavaImageDocumentEntity(): List<ImageDocument>
}

