package com.example.androiddevchallenge.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.lazyElements.LazyColumnSection
import com.example.androiddevchallenge.lazyElements.LazyRowSection

@Composable
fun HomeScreen() {
    Scaffold(bottomBar = { BottomBar() }) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.White)
        )
        {
            Column(
                Modifier
                    .paddingFromBaseline(top = 40.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Spacer(Modifier.height(40.dp))
                Search()
                LazyRowSection()
                Spacer(Modifier.height(40.dp))
                LazyColumnSection()
            }
        }
    }
}

@Composable
private fun Search() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = {
            Text("Search")
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .size(18.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    )
}

@Composable
private fun BottomBar() {
    BottomAppBar(
        backgroundColor = pink100
    ) {
        BloomBottomButton(
            selected = true,
            icon = Icons.Default.Home,
            labelText = "Home"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.FavoriteBorder,
            labelText = "Favorites"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.AccountCircle,
            labelText = "Profile"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.ShoppingCart,
            labelText = "Cart"
        )
    }
}

@Composable
private fun RowScope.BloomBottomButton(
    selected: Boolean,
    icon: ImageVector,
    labelText: String,
) {
    BottomNavigationItem(
        selected = selected,
        onClick = { /*TODO*/ },
        icon = {
            Icon(
                icon,
                contentDescription = null,
            )
        },
        label = {
            Text(labelText)
        }
    )
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomePreview() {
    HomeScreen()
}