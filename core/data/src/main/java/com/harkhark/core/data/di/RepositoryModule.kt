package com.harkhark.core.data.di

import com.harkhark.core.data.repository.LoveRepositoryImpl
import com.harkhark.core.domain.repository.LoveRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindLoveRepository(loveRepositoryImpl: LoveRepositoryImpl): LoveRepository

}