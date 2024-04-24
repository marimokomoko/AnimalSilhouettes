package com.example.animalsilhouettes.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animalsilhouettes.R

@Composable
fun AnimalCard(animalName: String, imgId: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(300.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color.LightGray.copy(alpha = 0.5f))
            .padding(horizontal = 10.dp, vertical = 20.dp)
    ) {
        Image(
            painter = painterResource(id = imgId),
            contentDescription = "cat",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Text(
            text = animalName,
            color = Color.DarkGray,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimalCardPre() {
    AnimalCard(
        animalName = "cat",
        imgId = R.drawable.cat
    )
}