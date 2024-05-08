package com.example.bootckakao.data.di

import com.example.bootckakao.domain.search.repository.DefaultSearchRepository
import com.example.bootckakao.data.repository.DefaultSearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSearchRepository(searchManagerImpl: DefaultSearchRepositoryImpl): DefaultSearchRepository

}