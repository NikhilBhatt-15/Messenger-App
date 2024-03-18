package com.example.loginpages.app.Components


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpages.R

@Composable
fun NormalTextComponent(value:String,modifier: Modifier=Modifier) {
    Text(text = value,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize =24.sp ,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), textAlign = TextAlign.Center
    )
}
@Composable
fun HeadingTextComponent(value:String,modifier: Modifier=Modifier) {
    Text(text = value,
        modifier = modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize =30.sp ,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ), textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextField(label:String,icon:Painter,isPassword:Boolean=false) {
    var text by remember {
        mutableStateOf("")
    }
    var isHidden by remember {
        mutableStateOf(true)
    }
    OutlinedTextField(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(4.dp)),value = text, onValueChange ={ text=it },
        keyboardOptions = KeyboardOptions(keyboardType = if(isPassword)KeyboardType.Password else KeyboardType.Text, imeAction = if (isPassword) ImeAction.Done else
        ImeAction.Next),
        leadingIcon = {
            Icon(painter = icon, contentDescription = null, tint = Color.White)
        },

        visualTransformation = if(isHidden and isPassword) PasswordVisualTransformation() else VisualTransformation.None ,
        colors = TextFieldDefaults.colors(focusedContainerColor = Color(0x0F686666)),
        singleLine = true,
        label = {
            Text(text = label)
        }
        , trailingIcon = {
            if(isPassword){
                Icon(modifier = Modifier.clickable { isHidden=!isHidden }, painter = painterResource(id = if(!isHidden) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24), contentDescription = "")
            }
            else{
                null
            }
        }
    )
}

@Composable
fun CheckBoxBar(modifier: Modifier=Modifier,value: String,onTextSelected: (String) -> Unit) {
    var isChecked by remember {
        mutableStateOf(false)
    }

    Row(modifier=modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Checkbox(checked = isChecked, onCheckedChange = {
            isChecked=it
        })
        ClickableTextComponent(value = value){
            onTextSelected(it)
        }
        
    }
}

@Composable
fun ClickableTextComponent(value: String,onTextSelected:(String)->Unit) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText="Privacy Policy"
    val and = " and "
    val termsAndConditionText="Terms of Use."

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)){
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(and)
        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)){
            pushStringAnnotation(tag = termsAndConditionText, annotation = termsAndConditionText)
            append(termsAndConditionText)
        }

    }
    ClickableText(text = annotatedString, onClick = {offset->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {
                Log.d("Clickable component: ","{${it.item}}")
                if(it.item == privacyPolicyText){
                    onTextSelected(it.item)
                }
                else if(it.item==termsAndConditionText){
                    onTextSelected(it.item)
                }
            }
    })
}


@Composable
fun ButtonComponent(value: String,modifier: Modifier= Modifier) {
    Box(modifier = modifier
        .fillMaxWidth()
        .heightIn(min = 52.dp)
        .clip(RoundedCornerShape(48.dp))
        .background(brush = Brush.horizontalGradient(listOf(Color.Cyan, Color.Blue, Color.Cyan)))
        .clickable { }
        , contentAlignment = Alignment.Center
    ) {
            Text(
                text = value,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
    }
}
@Preview
@Composable
fun DividerTextComponent() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f), color = Color.Gray, thickness = 2.dp)
        Text(modifier = Modifier.padding(8.dp), text = "or", fontSize = 18.sp)
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f), color = Color.Gray, thickness = 2.dp)
    }
}

@Composable
fun ClickableLoginTextComponent(value: String,onTextSelected: (String) -> Unit) {
    val initialText = "Already have an account? "
    val login = "login"
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)){
            pushStringAnnotation(tag = login, annotation = login)
            append(login)
        }
    }
    ClickableText(text = annotatedString, onClick ={offset->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {
                Log.d("Clickable component: ","{${it.item}}")
                if(it.item == login){
                    onTextSelected(it.item)
                }
            }

    } )
}

@Composable
fun LoginPageBar(value: String,onTextSelected: (String) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        ClickableLoginTextComponent(value = "", onTextSelected = onTextSelected)
    }
}


@Composable
fun RegisterPageBar(value: String,onTextSelected: (String) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        ClickableRegisterTextComponent(value = "", onTextSelected = onTextSelected)
    }
}
@Composable
fun ClickableRegisterTextComponent(value: String,onTextSelected: (String) -> Unit) {
    val initialText = "Doesn't have an account? "
    val register = "register"
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)){
            pushStringAnnotation(tag = register, annotation = register)
            append(register)
        }
    }
    ClickableText(text = annotatedString, onClick ={offset->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {
                Log.d("Clickable component: ","{${it.item}}")
                if(it.item == register){
                    onTextSelected(it.item)
                }
            }
    } )
}