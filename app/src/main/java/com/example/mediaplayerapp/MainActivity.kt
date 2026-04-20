package com.example.mediaplayerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Кнопка Изображения
        findViewById<Button>(R.id.btnImages).setOnClickListener {
            startActivity(Intent(this, ImagesActivity::class.java))
        }

        // Кнопка Музыка
        findViewById<Button>(R.id.btnMusic).setOnClickListener {
            startActivity(Intent(this, MusicActivity::class.java))
        }

        // Кнопка Видео
        findViewById<Button>(R.id.btnVideo).setOnClickListener {
            startActivity(Intent(this, VideoActivity::class.java))
        }
    }
}
