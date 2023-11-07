package com.sylv42240.data.di

import com.sylv42240.data.cache.CacheManager
import com.sylv42240.data.cache.CacheManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ManagerModule {

    @Binds
    @Singleton
    fun bindCacheManager(impl: CacheManagerImpl): CacheManager

}
