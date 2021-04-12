package com.example.androiddevchallenge.lazyElements

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.screens.buttonPrimary
import com.example.androiddevchallenge.screens.nunitoSansFamily
import com.example.androiddevchallenge.objects.Image

@Composable
fun LazyRowSection() {
    // text variables homescreen page
    val browseThemes = "Browse themes"
    val designGarden = "Design your home garden"
    // Make list of plants & fill it
    val imagesRow = mutableListOf<Image>()

    for (i in 5..9) {
        imagesRow.add(
            Image(
                imageResId = Image.IMAGES[i],
                name = Image.IMAGES_NAMES[i],
                description = Image.IMAGE_DESCRIPTIONS[i]
            )
        )
        Log.i("teki", i.toString())
    }
    Text(
        text = browseThemes,
        color = buttonPrimary,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
            .padding(horizontal = 16.dp),
    )

    Spacer(Modifier.height(16.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(152.dp)
    ) {
        items(imagesRow.size) { image ->
            ImageItemRow(imageProvided = imagesRow[image])
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            )
        }
    }
}

@Composable
fun ImageItemRow(imageProvided: Image) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .size(136.dp),
    ) {
        Column() {
            Image(
                painter = painterResource(id = imageProvided.imageResId),
                contentDescription = "Nature item",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(136.dp)
                    .height(96.dp)
            )
            Text(
                text = imageProvided.name,
                fontFamily = nunitoSansFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp,
                color = buttonPrimary,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun RowPreview() {
    LazyRowSection()
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun RowItemPreview() {
    val imageMock = Image(
        imageResId = com.example.androiddevchallenge.objects.Image.IMAGES[1],
        name = com.example.androiddevchallenge.objects.Image.IMAGES_NAMES[1],
        description = com.example.androiddevchallenge.objects.Image.IMAGE_DESCRIPTIONS[1]
    )
    ImageItemRow(imageMock)
}