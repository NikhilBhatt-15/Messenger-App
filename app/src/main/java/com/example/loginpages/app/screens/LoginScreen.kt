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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpages.app.Components.HeadingTextComponent
import com.example.loginpages.app.Components.MessengerRouter
import com.example.loginpages.app.Components.NormalTextComponent
import com.example.loginpages.app.Components.Screen
@Preview
@Composable
fun LoginScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(16.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HeadingTextComponent(value = "Login Screen")
            Spacer(modifier = Modifier.height(10.dp))
            NormalTextComponent(value = "Mutual Funds are subject to market risks. Please read all the documents carefully...")
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = { MessengerRouter.navigateTo(Screen.SignUpScreen)}) {
                Text(text = "Back")
            }
        }

    }
}