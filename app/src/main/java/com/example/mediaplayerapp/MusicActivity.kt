package com.example.mediaplayerapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MusicActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var currentSong = 0

    private lateinit var tvNowPlaying: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        tvNowPlaying = findViewById(R.id.tvNowPlaying)

        // Кнопки выбора песни
        findViewById<Button>(R.id.btnSong1).setOnClickListener { playSong(1) }
        findViewById<Button>(R.id.btnSong2).setOnClickListener { playSong(2) }
        findViewById<Button>(R.id.btnSong3).setOnClickListener { playSong(3) }

        // Кнопки управления
        findViewById<Button>(R.id.btnPlay).setOnClickListener { playCurrentSong() }
        findViewById<Button>(R.id.btnPause).setOnClickListener { pauseSong() }
        findViewById<Button>(R.id.btnStop).setOnClickListener { stopSong() }
    }

    private fun playSong(songNumber: Int) {
        stopSong() // останавливаем текущую песню

        currentSong = songNumber

        val rawId = when (songNumber) {
            1 -> R.raw.song1
            2 -> R.raw.song2
            3 -> R.raw.song3
            else -> R.raw.song1
        }

        mediaPlayer = MediaPlayer.create(this, rawId)
        mediaPlayer?.start()

        val songName = when (songNumber) {
            1 -> "Song 1 - Oh oh"
            2 -> "Song 2 - Música"
            3 -> "Song 3"
            else -> "Неизвестная песня"
        }

        tvNowPlaying.text = "Сейчас играет: $songName"
    }

    private fun playCurrentSong() {
        mediaPlayer?.start()
    }

    private fun pauseSong() {
        mediaPlayer?.pause()
    }

    private fun stopSong() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        tvNowPlaying.text = "Сейчас играет: —"
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}