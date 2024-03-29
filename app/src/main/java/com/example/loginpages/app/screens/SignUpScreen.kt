package com.example.loginpages.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.loginpages.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginpages.app.Components.ButtonComponent
import com.example.loginpages.app.Components.CheckBoxBar
import com.example.loginpages.app.Components.DividerTextComponent
import com.example.loginpages.app.Components.HeadingTextComponent
import com.example.loginpages.app.Components.LoginPageBar
import com.example.loginpages.app.Components.MessengerRouter
import com.example.loginpages.app.Components.MyTextField
import com.example.loginpages.app.Components.NormalTextComponent
import com.example.loginpages.app.Components.Screen
import com.example.loginpages.app.data.LoginViewModel
import com.example.loginpages.app.data.UiEvent


@Composable
fun SignUpScreen(loginViewModel: LoginViewModel= viewModel()) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(modifier = Modifier.padding(24.dp)) {

            NormalTextComponent(value = stringResource(id = com.example.loginpages.R.string.hello))
            HeadingTextComponent(value = "Create an account")
            Spacer(modifier = Modifier.height(16.dp))
            MyTextField(label = "first name", icon =  painterResource(id = R.drawable.baseline_person_24)
                ,isError = loginViewModel.registrationUiState.value.firstNameError
            ){
                loginViewModel.onEvent(UiEvent.FirstNameChanged(it))
            }
//            Spacer(modifier = Modifier.height(8.dp))
            MyTextField(label = "last name", icon =  painterResource(id = R.drawable.baseline_person_24)
                ,isError = loginViewModel.registrationUiState.value.lastNameError){
                loginViewModel.onEvent(UiEvent.LastNameChanged(it))
            }
//            Spacer(modifier = Modifier.height(8.dp))
            MyTextField(label = "e-mail", icon =  painterResource(id = R.drawable.baseline_email_24)
                ,isError = loginViewModel.registrationUiState.value.emailError){
                loginViewModel.onEvent(UiEvent.EmailChanged(it))
            }
//            Spacer(modifier = Modifier.height(8.dp))
            MyTextField(label = "password", icon =  painterResource(id = R.drawable.baseline_lock_24),true
                ,isError = loginViewModel.registrationUiState.value.passwordError){
                loginViewModel.onEvent(UiEvent.PasswordChanged(it))
            }
            CheckBoxBar(value = ""){
                    if(it == "Privacy Policy") {
                        MessengerRouter.navigateTo(Screen.PrivacyPolicy)
                    }else{
                        MessengerRouter.navigateTo(Screen.TermsAndCondition)
                    }
            }
            Spacer(modifier = Modifier.height(80.dp))
            ButtonComponent(value = "Register"){
                loginViewModel.onEvent(UiEvent.RegisterButtonClicked)
            }
            Spacer(modifier = Modifier.height(40.dp))
            DividerTextComponent()
            LoginPageBar(value = "", onTextSelected = {
                if(it=="login"){
                    MessengerRouter.navigateTo(Screen.LoginScreen)
                }
            })
        }

    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}