package com.example.bootckakao.domain.search.usecase

import com.example.bootckakao.domain.search.model.ImageDocumentEntity
import com.example.bootckakao.domain.search.repository.DefaultSearchRepository
import javax.inject.Inject

class GetAllSaveImageDocumentEntityUseCase @Inject constructor(
    private val searchRepository: DefaultSearchRepository
) {
    suspend operator fun invoke(): List<ImageDocumentEntity> = searchRepository.getAllSavaImageDocumentEntity()

}