package com.sylv42240.data.cache

import com.sylv42240.domain.model.FizzBuzzForm
import javax.inject.Inject


class CacheManagerImpl @Inject constructor() : CacheManager {

    private var currentForm: FizzBuzzForm? = null

    override fun setForm(form: FizzBuzzForm) {
        currentForm = form
    }

    override fun getForm(): FizzBuzzForm {
        return currentForm ?: throw NoSuchElementException()
    }

}