package com.sylv42240.data.repository


import com.sylv42240.data.cache.CacheManager
import com.sylv42240.domain.model.FizzBuzzForm
import com.sylv42240.domain.repository.FormRepository
import javax.inject.Inject

class FormRepositoryImpl @Inject constructor(
    private val cacheManager: CacheManager
) : FormRepository {

    override fun submitForm(form: FizzBuzzForm): Result<Boolean> {
        cacheManager.setForm(form = form)
        return Result.success(true)
    }

    override fun retrieveFizzBuzzList(): Result<List<String>> {
        try {
            val form = cacheManager.getForm()
            val numberList = 1..1000
            val updatedList = numberList.map { currentNumber ->
                val builder = StringBuilder()
                if (currentNumber % form.firstNumber == 0) {
                    builder.append(form.firstWord)
                }
                if (currentNumber % form.secondNumber == 0) {
                    builder.append(form.secondWord)
                }
                if (builder.isEmpty()) {
                    builder.append(currentNumber)
                }
                builder.toString()
            }
            return Result.success(value = updatedList)
        } catch (e: Exception) {
            return Result.failure(e)
        }

    }

}