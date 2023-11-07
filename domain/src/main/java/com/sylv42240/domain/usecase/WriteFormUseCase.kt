package com.sylv42240.domain.usecase

import com.sylv42240.domain.model.FizzBuzzForm
import com.sylv42240.domain.repository.FormRepository
import javax.inject.Inject

interface WriteFormUseCase {
    fun submitForm(firstNumber: Int, secondNumber: Int, firstWord: String, secondWord: String): Result<Boolean>
}

class DefaultWriteFormUseCase @Inject constructor(private val repository: FormRepository) :
    WriteFormUseCase {
    override fun submitForm(
        firstNumber: Int,
        secondNumber: Int,
        firstWord: String,
        secondWord: String
    ): Result<Boolean> {
        val form = FizzBuzzForm(
            firstNumber = firstNumber,
            secondNumber = secondNumber,
            firstWord = firstWord,
            secondWord = secondWord
        )

        return repository.submitForm(
            form = form
        )
    }

}