package com.sylv42240.fizz_buzz.di

import com.sylv42240.domain.usecase.DefaultReadFormUseCase
import com.sylv42240.domain.usecase.DefaultWriteFormUseCase
import com.sylv42240.domain.usecase.ReadFormUseCase
import com.sylv42240.domain.usecase.WriteFormUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCasesModule {

    @Binds
    fun bindWriteFormUseCase(impl: DefaultWriteFormUseCase): WriteFormUseCase

    @Binds
    fun bindReadFormUseCase(impl: DefaultReadFormUseCase): ReadFormUseCase
}