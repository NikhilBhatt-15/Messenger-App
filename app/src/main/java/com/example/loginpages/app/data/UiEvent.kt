package com.example.loginpages.app.data

sealed class UiEvent {
    data class FirstNameChanged(val firstName:String):UiEvent()
    data class LastNameChanged(val lastName:String):UiEvent()
    data class EmailChanged(val email:String):UiEvent()
    data class PasswordChanged(val password:String):UiEvent()
}