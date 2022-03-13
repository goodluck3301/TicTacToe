package com.example.tictactoegame

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val start = findViewById<Button>(R.id.start_game)

        val name1 = findViewById<EditText>(R.id.editText)
        val name2 = findViewById<EditText>(R.id.editText2)

        val x_score = findViewById<TextView>(R.id.x_score)
        val o_score = findViewById<TextView>(R.id.o_score)

        val intent = Intent(this, MainActivity2::class.java)

        start.setOnClickListener{

           if (name1.text.length != 0)
                intent.putExtra("p_name1",name1.text.toString())
           else
                intent.putExtra("p_name1","Player 1")

           if (name1.text.length != 0)
                intent.putExtra("p_name2",name2.text.toString())
           else
                intent.putExtra("p_name2","Player 2")

           startActivityForResult(intent,1000)
        }

        val xS = getIntent().extras
        val oS = getIntent().extras

        if (xS != null)
            x_score.text = xS.getString("x_score").toString()
        if (oS != null)
            o_score.text = oS.getString("o_score").toString()

        //
    }
}