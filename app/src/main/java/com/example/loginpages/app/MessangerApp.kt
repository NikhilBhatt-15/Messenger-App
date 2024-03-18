package com.example.loginpages.app


import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.loginpages.app.Components.MessengerRouter
import com.example.loginpages.app.Components.Screen
import com.example.loginpages.app.screens.LoginScreen
import com.example.loginpages.app.screens.PrivacyPolicyScreen
import com.example.loginpages.app.screens.SignUpScreen
import com.example.loginpages.app.screens.TermsAndConditionScreen

@Composable
fun MessengerApp() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {

        Crossfade(targetState = MessengerRouter.currentScreen, label = "") {
            when(it.value){
                is Screen.SignUpScreen ->{
                    SignUpScreen()
                }
                is Screen.PrivacyPolicy ->{
                    PrivacyPolicyScreen()
                }
                is Screen.TermsAndCondition-> {
                    TermsAndConditionScreen()
                }
                is Screen.LoginScreen->{
                    LoginScreen()
                }

            }
        }
    }
}