package com.example.bootckakao.domain.search.repository

import com.example.bootckakao.domain.search.model.SearchEntity

interface DefaultSearchRepository {

    //일반 api
    suspend fun requestSearch(query: String): SearchEntity

}

