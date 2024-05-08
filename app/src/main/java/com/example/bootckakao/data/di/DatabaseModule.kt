package com.example.bootckakao.data.di

import android.content.Context
import androidx.room.Room
import com.example.bootckakao.data.database.SaveImageDocumentDao
import com.example.bootckakao.data.database.SearchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesMeryDatabase(
        @ApplicationContext context: Context,
    ): SearchDatabase = Room.databaseBuilder(
        context = context,
        klass = SearchDatabase::class.java,
        name = "search-database"
    ).build()

    @Provides
    fun providesSearchDao(
        database: SearchDatabase,
    ): SaveImageDocumentDao = database.saveImageDocumentDao()
}