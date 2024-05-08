package com.example.bootckakao.domain.search.usecase

import com.example.bootckakao.data.model.local.SaveImageDocumentEntity
import com.example.bootckakao.domain.search.repository.DefaultSearchRepository
import javax.inject.Inject

class AddSaveImageDocumentEntityUseCase @Inject constructor(
    private val searchRepository: DefaultSearchRepository
) {
    suspend operator fun invoke(saveImageDocumentEntity: SaveImageDocumentEntity) {
        searchRepository.addSaveImageDocumentEntity(saveImageDocumentEntity)
    }
}
