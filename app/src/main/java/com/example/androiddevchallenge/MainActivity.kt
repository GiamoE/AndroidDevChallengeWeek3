/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.example.androiddevchallenge.screens.HomeScreen
import com.example.androiddevchallenge.screens.LoginScreen

class MainActivity : AppCompatActivity() {
    // style variables
    private val pink100 = Color(android.graphics.Color.parseColor("#FFF1F1"))
    private val buttonPrimary = Color(android.graphics.Color.parseColor("#3F2C2C"))
    private val nunitoSansFamily = FontFamily(Font(R.font.nunitosans_light, FontWeight.Light))

    // text variables welcome page
    private val subtitle1 = "Beautiful home garden solutions"
    private val login = "Log in"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }

    // Start building your app here!
    @Composable
    fun MyApp() {
        Surface(color = MaterialTheme.colors.background) {
            AppNavigator()
        }
    }

    @Composable
    fun WelcomeScreen(navController: NavController) {
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

    @Composable
    fun AppNavigator() {
        // Create a navigation controller
        val navController = rememberNavController()

        // Create the navigation host with its routes
        NavHost(
            navController = navController,
            startDestination = "welcomeScreen"
        ) {
            composable("welcomeScreen") {
                WelcomeScreen(navController)
            }
            composable("login") {
                LoginScreen(navController)
            }
            composable("homeScreen") {
                HomeScreen()
            }
        }
    }

    @Preview(widthDp = 360, heightDp = 640)
    @Composable
    fun HomePreview() {
        MyApp()
    }
}