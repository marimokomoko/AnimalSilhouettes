package com.example.animalsilhouettes.compose

import com.example.animalsilhouettes.R

/**
 * getSoundResourse:アニマルたちが鳴き声を返す関数
 * @param imgName アニマルたち画像の名前を受け取るプロパティ
 */
fun getSoundResourse(imgName: String): Int {
    return when (imgName) {
        "cat" -> R.raw.cat_sounds
        "dog" -> R.raw.dog_sounds
        "chicken" -> R.raw.chicken_sounds
        "lion" -> R.raw.lion_sounds
        "pig" -> R.raw.pipg_sounds
        // 他のアニマルたちは音声準備中(なかなか見つからない)
        else -> R.raw.else_dog
    }
}