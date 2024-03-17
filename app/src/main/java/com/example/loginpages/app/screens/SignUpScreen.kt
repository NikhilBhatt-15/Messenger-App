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
import com.example.loginpages.app.Components.ButtonComponent
import com.example.loginpages.app.Components.CheckBoxBar
import com.example.loginpages.app.Components.DividerTextComponent
import com.example.loginpages.app.Components.HeadingTextComponent
import com.example.loginpages.app.Components.MessengerRouter
import com.example.loginpages.app.Components.MyTextField
import com.example.loginpages.app.Components.NormalTextComponent
import com.example.loginpages.app.Components.Screen


@Composable
fun SignUpScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(modifier = Modifier.padding(24.dp)) {

            NormalTextComponent(value = stringResource(id = com.example.loginpages.R.string.hello))
            HeadingTextComponent(value = "Welcome To our App")
            Spacer(modifier = Modifier.height(16.dp))
            MyTextField(label = "first name", icon =  painterResource(id = R.drawable.baseline_person_24))
            Spacer(modifier = Modifier.height(8.dp))
            MyTextField(label = "last name", icon =  painterResource(id = R.drawable.baseline_person_24))
            Spacer(modifier = Modifier.height(8.dp))
            MyTextField(label = "e-mail", icon =  painterResource(id = R.drawable.baseline_email_24))
            Spacer(modifier = Modifier.height(8.dp))
            MyTextField(label = "password", icon =  painterResource(id = R.drawable.baseline_lock_24),true)
            CheckBoxBar(value = ""){
                    if(it == "Privacy Policy") {
                        MessengerRouter.navigateTo(Screen.PrivacyPolicy)
                    }else{
                        MessengerRouter.navigateTo(Screen.TermsAndCondition)
                    }
            }
            Spacer(modifier = Modifier.height(80.dp))
            ButtonComponent(value = "Register")
            Spacer(modifier = Modifier.height(40.dp))
            DividerTextComponent()
        }

    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}