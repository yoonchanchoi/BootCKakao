package com.example.bootckakao.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bootckakao.data.model.local.SaveImageDocumentEntity


@Database(entities = [SaveImageDocumentEntity::class], version = 1)
abstract class SearchDatabase: RoomDatabase() {
        abstract fun saveImageDocumentDao(): SaveImageDocumentDao
}