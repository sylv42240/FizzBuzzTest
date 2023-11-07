package com.sylv42240.data.cache

import com.sylv42240.domain.model.FizzBuzzForm

interface CacheManager {
    fun setForm(form: FizzBuzzForm)
    fun getForm(): FizzBuzzForm
}