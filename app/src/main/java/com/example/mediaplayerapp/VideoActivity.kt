package com.example.mediaplayerapp

import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        videoView = findViewById(R.id.videoView)

        // Указываем путь к видео в папке raw
        val videoPath = "android.resource://" + packageName + "/" + R.raw.video
        videoView.setVideoPath(videoPath)

        findViewById<Button>(R.id.btnPlayVideo).setOnClickListener {
            videoView.start()
        }

        findViewById<Button>(R.id.btnPauseVideo).setOnClickListener {
            videoView.pause()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (videoView.isPlaying) {
            videoView.stopPlayback()
        }
    }
}