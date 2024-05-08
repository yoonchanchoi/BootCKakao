package com.example.bootckakao.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("save_imageDocuments")
data class SaveImageDocumentEntity(
    @PrimaryKey
    val imageUrl: String = "",
    val collection: String = "",
    val thumbnailUrl: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val displaySitename: String = "",
    val docUrl: String = "",
    val datetime: String = "",
    var favorite: Boolean = false
)

