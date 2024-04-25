package com.example.animalsilhouettes.compose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animalsilhouettes.R

/**
 * AnimalView:アニマルたちのイメージ画像を表示する関数
 * @param id 機能追加等で使うかもしれないID(現在は未使用)
 * @param imgName シークレット用アニマルたち画像の名前を受け取るプロパティ
 * @param imgRId シークレット用アニマルたち画像のリソースIDを受け取るプロパティ
 */
@Composable
fun AnimalView(
//    id: Int,
    imgName: String,
    imgRId: Int,
) {
    var isVisible by remember { mutableStateOf(false) } // 正解用アニマルたちの表示制御用
    val soundResourceId = getSoundResourse(imgName) // アニマルの鳴き声を取得
    val soundPlayer = SoundPlayer(LocalContext.current, soundResourceId) // SoundPlayer初期化
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        // 鳴き声再生ボタン
        Button(onClick = {
            soundPlayer.start()
        }) {
            Icon(Icons.Filled.PlayArrow, contentDescription = "")
            Text(text = "鳴き声")
        }
        // アニマルたちのシルエット画像表示
        Image(
            painter = painterResource(id = imgRId),
            contentDescription = imgName,
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        // 正解用アニマルたちタップボタン
        Button(
            onClick = { isVisible = !isVisible },
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ) {
            val icon = if (isVisible) {
                Icons.Filled.KeyboardArrowDown
            } else {
                Icons.Filled.KeyboardArrowUp
            }
            Icon(
                icon,
                contentDescription = "KeyboardArrowDown",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("タップ")
        }
        Spacer(modifier = Modifier.height(20.dp))
        val painterId = when (imgName) {
            "cat" -> R.drawable.cat
            "dog" -> R.drawable.dog
            "chicken" -> R.drawable.chicken
            "lion" -> R.drawable.lion
            "pig" -> R.drawable.pig
            "crocodile" -> R.drawable.crocodile
            "hedgehog" -> R.drawable.hedgehog
            "koala" -> R.drawable.koala
            "owl" -> R.drawable.owl
            "turtle" -> R.drawable.turtle
            "rabbit" -> R.drawable.rabbit
            else -> null
        }
        Log.d("::::::::AnimaeView", "$isVisible & $imgName & $painterId")
        // タップボタンで表示制御
        if (isVisible && painterId != null) {
            correctAnswerAnimalImage(imgName, painterId)
        }
    }
}

//　正解用アニマルたちのイメージ画像を表示
@Composable
fun correctAnswerAnimalImage(imgName: String, painterId: Int) {
    Image(
        painter = painterResource(id = painterId),
        contentDescription = imgName,
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