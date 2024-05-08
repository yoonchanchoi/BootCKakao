package com.example.bootckakao.data.repository

import com.example.bootckakao.data.database.SaveImageDocumentDao
import com.example.bootckakao.data.datasource.SearchDataSource
import com.example.bootckakao.data.model.local.SaveImageDocumentEntity
import com.example.bootckakao.data.model.local.toImageDocumentEntity
import com.example.bootckakao.domain.search.model.SearchEntity
import com.example.bootckakao.data.model.remote.toEntity
import com.example.bootckakao.domain.search.model.Favorite
import com.example.bootckakao.domain.search.model.ImageDocumentEntity
import com.example.bootckakao.domain.search.repository.DefaultSearchRepository
import javax.inject.Inject

class DefaultSearchRepositoryImpl @Inject constructor(
    private val searchDataSource: SearchDataSource,
    private val saveImageDocumentDao: SaveImageDocumentDao
) : DefaultSearchRepository {


//    override suspend fun requestSearch(
//        query: String
//    ): SearchEntity =
//        searchDataSource.requestSearch(query).toEntity()

//    override suspend fun requestSearch(query: String): SearchEntity {
//        val searchResponse = searchDataSource.requestSearch(query)
//
//
//    }

    override suspend fun requestSearch(query: String): SearchEntity {
//        searchDataSource.requestSearch(query).toEntity().documents?.let {
//            it.map {imageDocumentEntity ->
//                if(saveImageDocumentDao.selectSaveImageDocumentEntity(imageDocumentEntity.imageUrl)!=null){
//                    imageDocumentEntity.favorite = Favorite.FAVORITE.isFavorite
//                }
//            }
//        }
//        val searchResponse = searchDataSource.requestSearch(query)
        val searchEntity = searchDataSource.requestSearch(query).toEntity()

        searchEntity.documents?.let {
            it.map { imageDocumentEntity ->
                if (saveImageDocumentDao.selectSaveImageDocumentEntity(imageDocumentEntity.imageUrl) != null) {
                    imageDocumentEntity.favorite = Favorite.FAVORITE.isFavorite
                } else {
                    imageDocumentEntity.favorite = Favorite.HATE.isFavorite
                }
            }
        }
//        searchResponse.documents.map {
//
//        }
//        searchEntity.documents.forEach {
//            it.entity()
//        }
        return searchEntity
    }

    override suspend fun addSaveImageDocumentEntity(saveImageDocumentEntity: SaveImageDocumentEntity) {
        saveImageDocumentDao.insert(saveImageDocumentEntity)
    }

    override suspend fun deleteSaveImageDocumentEntity(imageUrl: String) {
        saveImageDocumentDao.deleteSaveImageDocument(imageUrl)
    }

    override suspend fun getAllSavaImageDocumentEntity(): List<ImageDocumentEntity> {
        return saveImageDocumentDao.getAll().map {
            it.toImageDocumentEntity()
        }
    }


}