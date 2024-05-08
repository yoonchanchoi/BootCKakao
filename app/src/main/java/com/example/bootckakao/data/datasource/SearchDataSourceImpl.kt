package com.example.bootckakao.data.datasource

import com.example.bootckakao.data.model.remote.SearchResponse
import com.example.bootckakao.data.service.Service
import javax.inject.Inject

class SearchDataSourceImpl @Inject constructor(
    private val service: Service
) : SearchDataSource {
    override suspend fun requestSearch(query: String): SearchResponse =
        service.requestSearch(query, sort = "accuracy", page = 1, size = 80)
}