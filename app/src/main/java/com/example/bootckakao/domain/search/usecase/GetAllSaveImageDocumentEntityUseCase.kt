package com.example.bootckakao.domain.search.usecase

import com.example.bootckakao.domain.search.model.ImageDocument
import com.example.bootckakao.domain.search.repository.DefaultSearchRepository
import javax.inject.Inject

class GetAllSaveImageDocumentEntityUseCase @Inject constructor(
    private val searchRepository: DefaultSearchRepository
) {
    suspend operator fun invoke(): List<ImageDocument> = searchRepository.getAllSavaImageDocumentEntity()

}