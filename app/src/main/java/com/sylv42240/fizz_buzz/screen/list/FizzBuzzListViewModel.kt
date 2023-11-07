package com.sylv42240.fizz_buzz.screen.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sylv42240.domain.usecase.ReadFormUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FizzBuzzListViewModel @Inject constructor(private val readFormUseCase: ReadFormUseCase) :
    ViewModel() {

    private val _fizzBuzzList = MutableStateFlow<List<String>>(emptyList())
    val fizzBuzzList: StateFlow<List<String>> = _fizzBuzzList

    fun retrieveFizzBuzzList(onError: () -> Unit) {
        viewModelScope.launch {
            readFormUseCase.retrieveFizzBuzzList()
                .onSuccess { list ->
                    _fizzBuzzList.emit(list)
                }
                .onFailure { _ ->
                    onError()
                }
        }
    }

}