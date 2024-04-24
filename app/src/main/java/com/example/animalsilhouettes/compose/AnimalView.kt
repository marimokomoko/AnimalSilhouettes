package com.example.animalsilhouettes.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animalsilhouettes.R

@Composable
fun AnimalView(
    id: Int,
    imgName: String,
    imgRId: Int,
) {
    var isVisible by remember { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imgRId),
            contentDescription = imgName,
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { isVisible = !isVisible },
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ) {
            Icon(
                Icons.Filled.KeyboardArrowDown,
                contentDescription = "KeyboardArrowDown",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("タップ")
        }
        Spacer(modifier = Modifier.height(20.dp))
        val painterId = when (imgName) {
            "cat" -> R.drawable.cat
            "chicken" -> R.drawable.chicken
            "crocodile" -> R.drawable.crocodile
            "hedgehog" -> R.drawable.hedgehog
            "koala" -> R.drawable.koala
            "lion" -> R.drawable.lion
            "owl" -> R.drawable.owl
            "pig" -> R.drawable.pig
            "turtle" -> R.drawable.turtle
            "rabbit" -> R.drawable.rabbit
            else -> null
        }
        if (isVisible && painterId != null) {
            Image(
                painter = painterResource(id = painterId),
                contentDescription = "",
                modifier = Modifier
                    .size(250.dp)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = imgName,
                color = Color.DarkGray,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}