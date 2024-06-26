package com.example.animalsilhouettes.compose

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.animalsilhouettes.R

/**
 * SilhouettrsImage:シークレット用アニマルたちのイメージ画像を用意する関数
 */
@Composable
fun SilhouettrsImage() {
    Box(contentAlignment = Alignment.TopCenter) {
        val scrollState = rememberScrollState()
        val imgItems = listOf(
            Pair("cat", R.drawable.cat_si),
            Pair("dog", R.drawable.dog_si),
            Pair("chicken", R.drawable.chicken_si),
            Pair("lion", R.drawable.lion_si),
            Pair("pig", R.drawable.pig_si),
            Pair("crocodile", R.drawable.crocodile_si),
            Pair("hedgehog", R.drawable.hedgehog_si),
            Pair("koala", R.drawable.koala_si),
            Pair("owl", R.drawable.owl_si),
            Pair("turtle", R.drawable.turtle_si),
            Pair("rabbit", R.drawable.rabbit_si)
        )
        println(imgItems)
        Row(
            modifier = Modifier.horizontalScroll(scrollState)
        ) {
            imgItems.forEach { (imgName, imgResourceId) ->
                AnimalView(
//                    id = imgName.length,
                    imgName = imgName,
                    imgRId = imgResourceId,
                )
            }
        }
    }
}