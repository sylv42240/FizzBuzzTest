package com.sylv42240.domain.repository

import com.sylv42240.domain.model.FizzBuzzForm

interface FormRepository {
    fun submitForm(form: FizzBuzzForm): Result<Boolean>
    fun retrieveFizzBuzzList(): Result<List<String>>
}