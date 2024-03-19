package com.example.loginpages.app.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    private var registrationUiState = mutableStateOf(RegistrationUiState())

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
        }
    }
}