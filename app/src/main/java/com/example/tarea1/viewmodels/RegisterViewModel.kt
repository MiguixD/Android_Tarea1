package com.example.tarea1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {
    private val _inputUserText = MutableLiveData<String>()
    private val _inputPasswordText = MutableLiveData<String>()
    private val _inputConfirmPasswordText = MutableLiveData<String>()
    private val _isButtonEnabled = MutableLiveData<Boolean>()

    val isButtonEnabled: LiveData<Boolean> get()= _isButtonEnabled

    init {
        _isButtonEnabled.value = false
    }

    fun onUserTextChanged(value: String) {
        _inputUserText.value = value
        _isButtonEnabled.value = validateInput()
    }

    fun onPasswordTextChanged(value: String){
        _inputPasswordText.value = value
        _isButtonEnabled.value = validateInput()
    }

    fun onConfirmPasswordTextChanged(value: String){
        _inputConfirmPasswordText.value = value
        _isButtonEnabled.value = validateInput()
    }

    fun validateInput(): Boolean {
        return !_inputUserText.value.isNullOrEmpty() &&
                !_inputPasswordText.value.isNullOrEmpty() &&
                _inputPasswordText.value.length > 3 &&
                !_inputConfirmPasswordText.value.isNullOrEmpty() &&
                _inputConfirmPasswordText.value.length > 3
    }

    fun validateRegister(): Boolean {
        return _inputPasswordText.value == _inputConfirmPasswordText.value
    }
}