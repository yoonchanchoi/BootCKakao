package com.example.bootckakao.domain.search.repository

import com.example.bootckakao.data.model.local.SaveImageDocumentEntity
import com.example.bootckakao.domain.search.model.ImageDocumentEntity
import com.example.bootckakao.domain.search.model.SearchEntity

interface DefaultSearchRepository {

    //일반 api
    suspend fun requestSearch(query: String): SearchEntity

    suspend fun addSaveImageDocumentEntity(saveImageDocumentEntity: SaveImageDocumentEntity)

    suspend fun deleteSaveImageDocumentEntity(imageUrl: String)

    suspend fun getAllSavaImageDocumentEntity(): List<ImageDocumentEntity>
}

