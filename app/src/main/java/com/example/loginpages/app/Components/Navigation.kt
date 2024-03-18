package com.example.loginpages.app.Components

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen() {
    object SignUpScreen:Screen()
    object PrivacyPolicy:Screen()
    object TermsAndCondition:Screen()
    object LoginScreen:Screen()
}

object MessengerRouter{
    val currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigateTo(destination:Screen){
        currentScreen.value=destination
    }
}