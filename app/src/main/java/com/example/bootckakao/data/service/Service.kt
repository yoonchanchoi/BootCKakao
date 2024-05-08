package com.example.bootckakao.data.service

import com.example.bootckakao.data.model.remote.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("/v2/search/image")
    suspend fun requestSearch(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): SearchResponse

}