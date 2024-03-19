package com.example.loginpages.app.screens




import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpages.R
import com.example.loginpages.app.Components.ButtonComponent
import com.example.loginpages.app.Components.DividerTextComponent
import com.example.loginpages.app.Components.HeadingTextComponent
import com.example.loginpages.app.Components.MessengerRouter
import com.example.loginpages.app.Components.MyTextField
import com.example.loginpages.app.Components.NormalTextComponent
import com.example.loginpages.app.Components.RegisterPageBar
import com.example.loginpages.app.Components.Screen
import com.example.loginpages.app.MessengerApp

@Preview
@Composable
fun LoginScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        ) {
        Column(modifier = Modifier.padding(24.dp),horizontalAlignment = Alignment.CenterHorizontally) {
            NormalTextComponent(value = "Hey there")
            HeadingTextComponent(value = "Welcome back")
            MyTextField(label = "e-mail", icon = painterResource(id = R.drawable.baseline_email_24),false,isError = false){}
            MyTextField(label = "password", icon = painterResource(id = R.drawable.baseline_lock_24),isPassword = true,isError = false){}
            Spacer(modifier = Modifier.height(100.dp))
            ButtonComponent(value = "Login"){}
            Spacer(modifier = Modifier.height(25.dp))
            DividerTextComponent()
            Spacer(modifier = Modifier.height(50.dp))
            RegisterPageBar(value = "", onTextSelected = {
                MessengerRouter.navigateTo(Screen.SignUpScreen)
            })

        }

    }
}