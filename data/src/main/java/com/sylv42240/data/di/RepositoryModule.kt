package com.sylv42240.data.di

import com.sylv42240.data.repository.FormRepositoryImpl
import com.sylv42240.domain.repository.FormRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindFormRepository(impl: FormRepositoryImpl): FormRepository

}
