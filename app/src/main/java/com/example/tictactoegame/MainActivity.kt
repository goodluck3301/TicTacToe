package com.example.tictactoegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val start = findViewById<Button>(R.id.start_game)


        start.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent,1000)
        }
        //
    }
}