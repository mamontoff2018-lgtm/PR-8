package com.example.mediaplayerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ImagesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)

        // Пока просто открываем экран.
        // Изображения загружаются напрямую из XML (activity_images.xml)
    }
}