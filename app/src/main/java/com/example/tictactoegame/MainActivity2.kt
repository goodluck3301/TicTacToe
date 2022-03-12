package com.example.tictactoegame

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.graphics.drawable.toDrawable

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val back = findViewById<ImageView>(R.id.back)
        val player1 = findViewById<TextView>(R.id.player_one_name)      //player 1 [X] for show step
        val player2 = findViewById<TextView>(R.id.player_two_name)      //player 2 [O] for show step

        val row1_col1 = findViewById<Button>(R.id.row1_col1)            //row 1 buttons
        val row1_col2 = findViewById<Button>(R.id.row1_col2)
        val row1_col3 = findViewById<Button>(R.id.row1_col3)

        val row2_col1 = findViewById<Button>(R.id.row2_col1)            //row 2 buttons
        val row2_col2 = findViewById<Button>(R.id.row2_col2)
        val row2_col3 = findViewById<Button>(R.id.row2_col3)

        val row3_col1 = findViewById<Button>(R.id.row3_col1)            //row 3 buttons
        val row3_col2 = findViewById<Button>(R.id.row3_col2)
        val row3_col3 = findViewById<Button>(R.id.row3_col3)

        player1.background = getDrawable(R.drawable.board_background)   // show [X] first step

        val board_array: Array<Int> =
            arrayOf(
                0,0,0, //row 1
                0,0,0, //row 2
                0,0,0) //row 3

        back.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivityForResult(intent,1000)
        }// back button

//row 1


        row1_col1.setOnClickListener{
          if (cheker(board_array,0))
            when(chek_cont_xo(board_array)){
                true  -> {
                    player2.background = getDrawable(R.drawable.board_background)
                    player1.background = null

                    row1_col1.background = getDrawable(R.drawable.x)
                    board_array[0] = 1
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row1_col1.background = getDrawable(R.drawable.o)
                    board_array[0] = 2
                }
            }
        }   // row1_col1

        row1_col2.setOnClickListener{
            if (cheker(board_array,1))
            when(chek_cont_xo(board_array)){
                true  -> {
                    player2.background = getDrawable(R.drawable.board_background)
                    player1.background = null

                    row1_col2.background = getDrawable(R.drawable.x)
                    board_array[1] = 1
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row1_col2.background = getDrawable(R.drawable.o)
                    board_array[1] = 2
                }
            }
        } // row1_col2

        row1_col3.setOnClickListener{
            if (cheker(board_array,2))
            when(chek_cont_xo(board_array)){
                true  -> {
                    player2.background = getDrawable(R.drawable.board_background)
                    player1.background = null

                    row1_col3.background = getDrawable(R.drawable.x)
                    board_array[2] = 1
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row1_col3.background = getDrawable(R.drawable.o)
                    board_array[2] = 2
                }
            }
        } // row1_col3

//row 2

        row2_col1.setOnClickListener{
            if (cheker(board_array,3))
            when(chek_cont_xo(board_array)){
                true  -> {
                    player2.background = getDrawable(R.drawable.board_background)
                    player1.background = null

                    row2_col1.background = getDrawable(R.drawable.x)
                    board_array[3] = 1
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row2_col1.background = getDrawable(R.drawable.o)
                    board_array[3] = 2
                }
            }
        }   // row1_col1

        row2_col2.setOnClickListener{
            if (cheker(board_array,4))
                when(chek_cont_xo(board_array)){
                    true  -> {
                        player2.background = getDrawable(R.drawable.board_background)
                        player1.background = null

                        row2_col2.background = getDrawable(R.drawable.x)
                        board_array[4] = 1
                    }
                    false -> {
                        player1.background = getDrawable(R.drawable.board_background)
                        player2.background = null

                        row2_col2.background = getDrawable(R.drawable.o)
                        board_array[4] = 2
                    }
                }

        } // row1_col2

        row2_col3.setOnClickListener{
            if (cheker(board_array,5))
            when(chek_cont_xo(board_array)){
                true  -> {
                    player2.background = getDrawable(R.drawable.board_background)
                    player1.background = null

                    row2_col3.background = getDrawable(R.drawable.x)
                    board_array[5] = 1
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row2_col3.background = getDrawable(R.drawable.o)
                    board_array[5] = 2
                }
            }
        } // row2_col3

// row 3

        row3_col1.setOnClickListener{

            if (cheker(board_array,6))
            when(chek_cont_xo(board_array)){
                true -> {
                    player2.background = getDrawable(R.drawable.board_background)
                    player1.background = null

                    row3_col1.background = getDrawable(R.drawable.x)
                    board_array[6] = 1
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row3_col1.background = getDrawable(R.drawable.o)
                    board_array[6] = 2
                }
            }
        }   // row1_col1

        row3_col2.setOnClickListener{
            if (cheker(board_array,7))
            when(chek_cont_xo(board_array)){
                true  -> {
                    player2.background = getDrawable(R.drawable.board_background)
                    player1.background = null

                    row3_col2.background = getDrawable(R.drawable.x)
                    board_array[7] = 1
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row3_col2.background = getDrawable(R.drawable.o)
                    board_array[7] = 2
                }
            }
        } // row1_col2

        row3_col3.setOnClickListener{

            if (cheker(board_array,8))
            when(chek_cont_xo(board_array)){
                true  -> {
                    player2.background = getDrawable(R.drawable.board_background)
                    player1.background = null

                    row3_col3.background = getDrawable(R.drawable.x)
                    board_array[8] = 1
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row3_col3.background = getDrawable(R.drawable.o)
                    board_array[8] = 2
                }
            }
        } // row2_col3
    }
}///


fun chek_cont_xo(array: Array<Int>):Boolean{
    var x_count = 0
    var o_count = 0

    array.forEachIndexed{i,e ->
        if (e == 1)
            x_count++
        if (e == 2)
            o_count++
    }//

    return if (x_count <= o_count)
        true
    else
        false
}


fun cheker(array: Array<Int>, i:Int):Boolean {

    if (array[i] == 0)
            return true
    return false
}
