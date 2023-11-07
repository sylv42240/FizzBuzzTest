package com.sylv42240.fizz_buzz.screen.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.sylv42240.domain.usecase.WriteFormUseCase
import com.sylv42240.fizz_buzz.screen.list.FizzBuzzListScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(private val writeFormUseCase: WriteFormUseCase) :
    ViewModel() {

    private val _showHeaderCard = MutableStateFlow(true)
    val showHeaderCard: StateFlow<Boolean> = _showHeaderCard

    private val _firstNumberInput = MutableStateFlow("")
    val firstNumberInput: StateFlow<String> = _firstNumberInput

    private val _secondNumberInput = MutableStateFlow("")
    val secondNumberInput: StateFlow<String> = _secondNumberInput

    private val _firstWordInput = MutableStateFlow("")
    val firstWordInput: StateFlow<String> = _firstWordInput

    private val _secondWordInput = MutableStateFlow("")
    val secondWordInput: StateFlow<String> = _secondWordInput

    val isButtonEnabled = combine(
        _firstWordInput,
        _secondWordInput,
        _firstNumberInput,
        _secondNumberInput
    ) { firstWord, secondWord, firstNumber, secondNumber ->
        firstWord.isNotBlank() && secondWord.isNotBlank() && firstNumber.isNotBlank() && secondNumber.isNotBlank()
    }

    fun submitForm(navController: NavController) {
        viewModelScope.launch {
            writeFormUseCase.submitForm(
                firstNumber = _firstNumberInput.value.toInt(),
                secondNumber = _secondNumberInput.value.toInt(),
                firstWord = _firstWordInput.value,
                secondWord = _secondWordInput.value
            ).onSuccess {
                navController.navigate(FizzBuzzListScreen.getRoute())
            }
        }
    }

    fun onFirstWordInputValueChanged(input: String) {
        viewModelScope.launch {
            _firstWordInput.emit(input)
        }
    }

    fun onSecondWordInputValueChanged(input: String) {
        viewModelScope.launch {
            _secondWordInput.emit(input)
        }
    }

    fun onFirstNumberInputValueChanged(input: String) {
        viewModelScope.launch {
            if (input.isEmpty()) {
                _firstNumberInput.emit(input)
            } else {
                input.toIntOrNull()?.let {
                    _firstNumberInput.emit(input)
                }
            }
        }
    }

    fun onSecondNumberInputValueChanged(input: String) {
        viewModelScope.launch {
            if (input.isEmpty()) {
                _secondNumberInput.emit(input)
            } else {
                input.toIntOrNull()?.let {
                    _secondNumberInput.emit(input)
                }
            }
        }

    }

    fun hideHeaderCard(){
        viewModelScope.launch {
            _showHeaderCard.emit(false)
        }
    }

}