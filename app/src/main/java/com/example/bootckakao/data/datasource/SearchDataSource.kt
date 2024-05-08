package com.example.bootckakao.data.datasource

import com.example.bootckakao.data.model.remote.SearchResponse

interface SearchDataSource {
    suspend fun requestSearch(query: String): SearchResponse
}