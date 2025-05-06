package com.example.catmeowapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    lateinit var frameAnim : AnimationDrawable
    lateinit var meowSound : MediaPlayer

    lateinit var catImage : ImageView

    lateinit var catButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        catImage = findViewById(R.id.catImage)
        catButton = findViewById(R.id.button)

        catButton.setOnClickListener {
           catImage.setImageResource(R.drawable.cat_anim)
            frameAnim = catImage.drawable as AnimationDrawable

            catImage.post {
                frameAnim.start()
            }

            meowSound = MediaPlayer.create(this, R.raw.catmeow)
            meowSound.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        meowSound.release()
    }


}