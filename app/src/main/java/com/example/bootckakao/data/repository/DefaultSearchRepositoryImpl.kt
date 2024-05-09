package com.example.bootckakao.data.repository

import com.example.bootckakao.data.database.SaveImageDocumentDao
import com.example.bootckakao.data.datasource.SearchDataSource
import com.example.bootckakao.data.model.local.SaveImageDocumentEntity
import com.example.bootckakao.data.model.local.toImageDocumentEntity
import com.example.bootckakao.data.model.remote.toEntity
import com.example.bootckakao.data.model.remote.toImageDocument
import com.example.bootckakao.domain.search.model.ImageDocument
import com.example.bootckakao.domain.search.repository.DefaultSearchRepository
import javax.inject.Inject

class DefaultSearchRepositoryImpl @Inject constructor(
    private val searchDataSource: SearchDataSource,
    private val saveImageDocumentDao: SaveImageDocumentDao
) : DefaultSearchRepository {


    override suspend fun requestSearch(query: String): List<ImageDocument> {
        val searchEntity = searchDataSource.requestSearch(query)
        val imageUrls = saveImageDocumentDao.getAllImageUrl()
        return searchEntity.documents?.map { imageDocumentResponse ->
            if (imageUrls.contains(imageDocumentResponse.imageUrl)) imageDocumentResponse.toImageDocument(
                true
            ) else imageDocumentResponse.toImageDocument(false)
        }?: emptyList()
    }

    override suspend fun addSaveImageDocumentEntity(imageDocument: ImageDocument) {
        saveImageDocumentDao.insert(imageDocument.toEntity())
    }

    override suspend fun deleteSaveImageDocumentEntity(imageUrl: String) {
        saveImageDocumentDao.deleteSaveImageDocument(imageUrl)
    }

    override suspend fun getAllSavaImageDocumentEntity(): List<ImageDocument> {
        return saveImageDocumentDao.getAll().map {
            it.toImageDocumentEntity()
        }
    }



}