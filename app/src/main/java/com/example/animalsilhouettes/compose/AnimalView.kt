package com.example.animalsilhouettes.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.dp
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
                .size(250.dp)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { isVisible = !isVisible },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White,
            ),
//            colors = ButtonDefaults.buttonColors(
//                backgroundColor = if (isVisible) Color.Green else Color.Red
//            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("？？？")
        }


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
            else -> R.drawable.cat // デフォルトの画像
        }
        if (isVisible) {
            Image(
                painter = painterResource(id = painterId),
                contentDescription = "あとで",
                modifier = Modifier
                    .size(150.dp) // 画像のサイズを設定
                    .padding(8.dp) // 余白を追加
            )
        }
    }
}
