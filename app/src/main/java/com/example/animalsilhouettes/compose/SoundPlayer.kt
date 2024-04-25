package com.example.animalsilhouettes.compose

import android.content.Context
import android.media.MediaPlayer
import android.provider.MediaStore.Audio.Media

class SoundPlayer(context: Context, rawRId: Int) {
    private var mediaPlayer: MediaPlayer = MediaPlayer()
    init {
        mediaPlayer = MediaPlayer.create(context, rawRId)
    }
    fun start() {
        mediaPlayer.start()
    }
    fun stop() {
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}