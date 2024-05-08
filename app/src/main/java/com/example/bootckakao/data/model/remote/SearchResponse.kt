package com.example.bootckakao.data.model.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResponse(

    @SerializedName("meta")
    @Expose
    val meta: MetaResponse? = null,

    @SerializedName("documents")
    @Expose
    val documents: List<ImageDocumentResponse>? = null

)
