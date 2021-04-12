package com.example.androiddevchallenge.objects

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class Image (
    @DrawableRes var imageResId: Int,
    var name: String,
    var description: String
    ) {
    companion object {
        val IMAGES = arrayOf(
            R.drawable.monstera,
            R.drawable.aglaonema,
            R.drawable.peace_lily,
            R.drawable.fiddle_leaf,
            R.drawable.snake_plant,
            R.drawable.desert_chic,
            R.drawable.tiny_terrariums,
            R.drawable.jungle_vibes,
            R.drawable.pothos,
            R.drawable.easy_care
        )
        val IMAGES_NAMES = arrayOf(
            "Monstera",
            "Aglaonema",
            "Peace lily",
            "Fiddle leaf tree",
            "Snake plant",
            "Desert chic",
            "Tiny terrariums",
            "Jungle vibes",
            "Pothos",
            "Easy Care"
        )

        val IMAGE_DESCRIPTIONS = arrayOf(
            "This is a description",
            "This is a description",
            "This is a description",
            "This is a description",
            "This is a description",
            "This is a description",
            "This is a description",
            "This is a description",
            "This is a description",
            "This is a description"
        )
    }
}