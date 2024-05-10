package com.example.bootckakao.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bootckakao.data.model.local.SaveImageDocumentEntity

@Dao
interface SaveImageDocumentDao {

    @Query("SELECT * FROM save_imageDocuments")
    suspend fun getAll(): List<SaveImageDocumentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(saveImageDocumentEntity: SaveImageDocumentEntity)

    @Query("SELECT * FROM save_imageDocuments WHERE imageUrl = :imageUrl")
    suspend fun selectSaveImageDocumentEntity(imageUrl: String): SaveImageDocumentEntity?

    @Query("SELECT * FROM save_imageDocuments WHERE imageUrl in (:imageUrls)")
    suspend fun selectSaveImageDocumentEntity(imageUrls: List<String>): List<SaveImageDocumentEntity>

    @Query("SELECT imageUrl FROM save_imageDocuments")
    suspend fun getAllImageUrl(): List<String>


    @Query("DELETE FROM save_imageDocuments WHERE imageUrl = :imageUrl")
    suspend fun deleteSaveImageDocument(imageUrl: String)


//예제
//    @Query("SELECT questionId FROM recommendation_questions WHERE userId = :userId AND date = :date")
//    fun getRecommendationQuestionIdFlow(userId: String, date: LocalDate): Flow<Long?>
//
//    @Upsert
//    suspend fun setRecommendationQuestion(entity: RecommendationQuestionEntity)

//    OnConflictStrategy.ABORT	충돌이 발생할 경우 처리 중단
//    OnConflictStrategy.FAIL	충돌이 발생할 경우 실패처리
//    OnConflictStrategy.IGNORE	충돌이 발생할 경우 무시
//    OnConflictStrategy.REPLACE	충돌이 발생할 경우 덮어쓰기
//    OnConflictStrategy.ROLLBACK	충돌이 발생할 경우 이전으로 되돌리기
}