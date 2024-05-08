package com.example.bootckakao.domain.search.usecase

import com.example.bootckakao.domain.search.repository.DefaultSearchRepository
import javax.inject.Inject

class DeleteSaveImageDocumentEntityUseCase @Inject constructor(
    private val searchRepository: DefaultSearchRepository
) {
    suspend operator fun invoke(imageUrl: String) {
        searchRepository.deleteSaveImageDocumentEntity(imageUrl)
    }
}
