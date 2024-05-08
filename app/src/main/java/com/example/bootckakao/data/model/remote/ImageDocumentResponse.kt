package com.example.bootckakao.data.model.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

data class ImageDocumentResponse(
    @SerializedName("collection")
    @Expose
    val collection: String = "",

    @SerializedName("thumbnail_url")
    @Expose
    val thumbnailUrl: String = "",

    @SerializedName("image_url")
    @Expose
    val imageUrl: String = "",

    @SerializedName("width")
    @Expose
    val width: Int = 0,

    @SerializedName("height")
    @Expose
    val height: Int = 0,

    @SerializedName("display_sitename")
    @Expose
    val displaySitename: String = "",

    @SerializedName("doc_url")
    @Expose
    val docUrl: String = "",

    @SerializedName("datetime")
    @Expose
    val datetime: String = "",
)
