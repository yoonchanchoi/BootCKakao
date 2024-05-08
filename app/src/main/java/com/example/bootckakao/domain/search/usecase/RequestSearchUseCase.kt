package com.example.bootckakao.domain.search.usecase

import com.example.bootckakao.domain.search.model.ImageDocumentEntity
import com.example.bootckakao.domain.search.model.SearchEntity
import com.example.bootckakao.domain.search.repository.DefaultSearchRepository
import javax.inject.Inject

class RequestSearchUseCase @Inject constructor(
    private val searchRepository: DefaultSearchRepository
) {
    suspend operator fun invoke(query: String): List<ImageDocumentEntity> = searchRepository.requestSearch(query)
}
