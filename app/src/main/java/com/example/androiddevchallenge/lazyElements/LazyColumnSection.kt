package com.example.androiddevchallenge.lazyElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.screens.buttonPrimary
import com.example.androiddevchallenge.screens.nunitoSansFamily
import com.example.androiddevchallenge.objects.Image
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.screens.white

@Composable
fun LazyColumnSection() {
    // Text variables for Column
    val designGarden = "Design your home garden"

    // Make list of plants & fill it
    val imagesColumn = mutableListOf<Image>()
    for (i in 0..4) {
        imagesColumn.add(
            Image(
                imageResId = Image.IMAGES[i],
                name = Image.IMAGES_NAMES[i],
                description = Image.IMAGE_DESCRIPTIONS[i]
            )
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .paddingFromBaseline(bottom = 20.dp)
            .padding(horizontal = 16.dp)
            .padding(bottom = 10.dp)
    ) {
        Text(
            text = designGarden,
            color = buttonPrimary,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .weight(1F)
        )

        Icon(
            Icons.Default.FilterList,
            contentDescription = "Filter",
            modifier = Modifier
                .size(24.dp)
        )
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 36.dp)
    ) {
        items(imagesColumn.size) { image ->
            ImageItemColumn(imageNumber = image)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            )
        }
    }
}

@Composable
fun ImageItemColumn(imageNumber: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = Image.IMAGES[imageNumber]),
            contentDescription = "Nature item",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(MaterialTheme.shapes.small),
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    text = Image.IMAGES_NAMES[imageNumber],
                    fontFamily = nunitoSansFamily,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp,
                    color = buttonPrimary
                )
                Spacer(modifier = Modifier.height(10.dp))
                PlantCheckbox()
            }
            Text(
                text = Image.IMAGE_DESCRIPTIONS[imageNumber],
                fontFamily = nunitoSansFamily,
                color = buttonPrimary,
                fontWeight = FontWeight.ExtraLight
            )
            Spacer(modifier = Modifier.height(10.dp))
            Divider(thickness = 2.dp)
        }
    }
}

@Composable
private fun PlantCheckbox() {
    val checkedState = remember {
        mutableStateOf(false)
    }

    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { isChecked ->
            checkedState.value = isChecked
        },
        colors = CheckboxDefaults.colors(
            checkmarkColor = white,
            checkedColor = buttonPrimary
        ),
        modifier = Modifier
            .size(24.dp)
    )
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun ColumnPreview() {
    MyTheme(darkTheme = true) {
        LazyColumnSection()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun ColumnItemPreview() {
    ImageItemColumn(1)
}