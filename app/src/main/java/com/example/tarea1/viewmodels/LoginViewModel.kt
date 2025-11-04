package com.example.tarea1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private val _inputUserText = MutableLiveData<String>()
    private val _inputPasswordText = MutableLiveData<String>()
    private val _isButtonEnabled = MutableLiveData<Boolean>()

    val isButtonEnabled: LiveData<Boolean> get()= _isButtonEnabled

    init{
        _isButtonEnabled.value = false
    }

    fun onUserTextChanged(value: String)
    {
        _inputUserText.value = value
        _isButtonEnabled.value = validateInput()
    }

    fun onPasswordTextChanged(value: String){
        _inputPasswordText.value = value
        _isButtonEnabled.value = validateInput()
    }

    fun validateInput(): Boolean
    {
        return !_inputUserText.value.isNullOrEmpty() &&
                !_inputPasswordText.value.isNullOrEmpty() &&
                _inputPasswordText.value.length > 3
    }
}