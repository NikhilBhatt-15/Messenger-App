package com.example.loginpages.app.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.loginpages.app.rules.Validator

class LoginViewModel:ViewModel() {
     var registrationUiState = mutableStateOf(RegistrationUiState())

    fun onEvent(event:UiEvent){
        when(event){
            is UiEvent.FirstNameChanged->{
                registrationUiState.value.firstName=event.firstName
                Log.d("Login",registrationUiState.value.toString())

            }
            is UiEvent.LastNameChanged->{
                registrationUiState.value.lastName=event.lastName
                Log.d("Login",registrationUiState.value.toString())
            }
            is UiEvent.EmailChanged->{
                registrationUiState.value.email=event.email
                Log.d("Login",registrationUiState.value.toString())
            }
            is UiEvent.PasswordChanged->{
                registrationUiState.value.password=event.password
                Log.d("Login",registrationUiState.value.toString())
            }
            is UiEvent.RegisterButtonClicked->{
                signUp()
            }
        }
    }

    private fun signUp() {
        registrationUiState.value.firstNameError=!Validator.validateFirstName(registrationUiState.value.firstName).isValid
        registrationUiState.value.lastNameError=!Validator.validateLastName(registrationUiState.value.lastName).isValid
        registrationUiState.value.emailError=!Validator.validateEmail(registrationUiState.value.email).isValid
        registrationUiState.value.passwordError=!Validator.validatePassword(registrationUiState.value.password).isValid
        Log.d("Sign",registrationUiState.value.toString())
    }
}