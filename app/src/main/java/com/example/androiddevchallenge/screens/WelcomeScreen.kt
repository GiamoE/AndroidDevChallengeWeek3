package com.example.androiddevchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R

@Composable
fun WelcomeScreen(navController: NavController) {
    // text variables welcome page
    val subtitle1 = "Beautiful home garden solutions"
    val login = "Log in"
    fun navigateToLogin() {
        try {
            navController.navigate("login")
        } catch (e: Exception) {
        }
    }
    Box(
        Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(color = pink100)
    ) {
        Image(
            painter = painterResource(id = R.drawable.light_welcome_bg),
            contentDescription = "Welcome background leaf white",
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )
        Column(
            Modifier
                .paddingFromBaseline(top = 72.dp)
                .fillMaxHeight()
                .padding(start = 88.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        )
        {
            Image(
                painter = painterResource(id = R.drawable.light_welcome_illos),
                contentDescription = "Welcome background leaf dark",
                Modifier
                    .height(500.dp)
                    .width(300.dp)
            )
        }
        Column(
            Modifier
                .paddingFromBaseline(top = 550.dp)
                .padding(start = 70.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.light_logo),
                contentDescription = "Light logo",
                Modifier
                    .width(200.dp)
                    .height(40.dp)
            )
            Spacer(modifier = Modifier.padding(top = 5.dp))
            Text(
                text = subtitle1,
                fontFamily = nunitoSansFamily,
                color = buttonPrimary
            )
        }
        Column(
            Modifier
                .paddingFromBaseline(top = 650.dp)
                .padding(start = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {},
                Modifier
                    .paddingFromBaseline(top = 100.dp)
                    .height(48.dp)
                    .width(320.dp)
                    .background(color = Color.White)
                    .clip(shape = CircleShape),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    backgroundColor = buttonPrimary
                )
            ) {
                Text(
                    text = "Create Account",
                    fontFamily = nunitoSansFamily
                )
            }
            Spacer(modifier = Modifier.padding(top = 40.dp))
            Text(
                modifier = Modifier.clickable { navigateToLogin() },
                text = login,
                fontFamily = nunitoSansFamily,
                color = buttonPrimary,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}