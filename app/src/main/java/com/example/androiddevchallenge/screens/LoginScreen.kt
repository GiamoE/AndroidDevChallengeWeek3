package com.example.androiddevchallenge.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R

// text variables login page
private const val loginemail = "Log in with email"
private const val emailField = "Email address"
private const val passwordField = "Password (8+ characters)"
private const val subtext1 = "By clicking below, you agree to our "
private const val termsOfUse = "Terms of Use "
private const val subtext2 = "and consent"
private const val subtext3 = "to our "
private const val privacy = "Privacy Policy"
private var email = ""
private var password = ""

// style variables
val buttonPrimary = Color(android.graphics.Color.parseColor("#3F2C2C"))
val white = Color(android.graphics.Color.parseColor("#FFFFFF"))
val nunitoSansFamily = FontFamily(Font(R.font.nunitosans_light, FontWeight.Light))
val pink100 = Color(android.graphics.Color.parseColor("#FFF1F1"))

@Composable
fun LoginScreen(navControl: NavController) {
    fun navigateToHome() {
        try {
            navControl.navigate("homeScreen")
        } catch (e: Exception) {
        }
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    )
    {
        Column(
            Modifier
                .paddingFromBaseline(166.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = loginemail,
                fontFamily = nunitoSansFamily,
                color = buttonPrimary,
                fontWeight = FontWeight.W900,
                fontSize = 22.sp
            )
            Spacer(Modifier.height(10.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(white)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    ),
                textStyle = TextStyle(color = buttonPrimary),
                label = { Text(text = emailField, color = buttonPrimary) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Spacer(Modifier.height(10.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    ),
                textStyle = TextStyle(color = buttonPrimary),
                visualTransformation = PasswordVisualTransformation(),
                label = { Text(text = passwordField, color = buttonPrimary) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )
            Column(
                Modifier
                    .padding(top = 20.dp, start = 15.dp, end = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = buttonPrimary,
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                    ) {
                        append(subtext1)
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append(termsOfUse)
                        }
                        append(subtext2)
                    }
                })
                Text(buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = buttonPrimary,
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                    ) {
                        append(subtext3)
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append(privacy)
                        }
                    }
                })
                Button(
                    onClick = { navigateToHome() },
                    Modifier
                        .paddingFromBaseline(top = 50.dp)
                        .height(48.dp)
                        .width(370.dp)
                        .background(color = Color.White)
                        .clip(shape = CircleShape),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        backgroundColor = buttonPrimary
                    )
                ) {
                    Text(
                        text = "Log in",
                        fontFamily = nunitoSansFamily,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}