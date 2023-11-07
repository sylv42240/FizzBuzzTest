package com.sylv42240.domain.usecase

import com.sylv42240.domain.repository.FormRepository
import javax.inject.Inject

interface ReadFormUseCase {
    fun retrieveFizzBuzzList(): Result<List<String>>
}

class DefaultReadFormUseCase @Inject constructor(private val repository: FormRepository) :
    ReadFormUseCase {
    override fun retrieveFizzBuzzList(): Result<List<String>> {
        return repository.retrieveFizzBuzzList()
    }

}