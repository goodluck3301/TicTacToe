package com.example.tictactoegame

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val start = findViewById<Button>(R.id.start_game)
        val name1 = findViewById<EditText>(R.id.editText)
        val name2 = findViewById<EditText>(R.id.editText2)


        start.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("p_name1",name1.text.toString())
                intent.putExtra("p_name2",name2.text.toString())
            startActivityForResult(intent,1000)
        }


        //
    }
}