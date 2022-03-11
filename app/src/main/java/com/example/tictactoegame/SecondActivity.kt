package com.example.tictactoegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val back = findViewById<ImageView>(R.id.back)

        back.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivityForResult(intent,1000)
        }// back button



    }
}