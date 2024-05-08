package com.example.bootckakao.data.di

import com.example.bootckakao.data.datasource.SearchDataSource
import com.example.bootckakao.data.datasource.SearchDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindSearchDataSource(searchDataSourceImpl: SearchDataSourceImpl): SearchDataSource

}