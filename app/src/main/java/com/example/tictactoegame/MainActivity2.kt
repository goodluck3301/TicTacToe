package com.example.tictactoegame

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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




        var board_array: Array<Int> =
            arrayOf(
                0,0,0, //row 1
                0,0,0, //row 2
                0,0,0) //row 3

        fun reset_game() {
            row1_col1.background = getColor(R.color.dark_purple).toDrawable()
            row1_col2.background = getColor(R.color.dark_purple).toDrawable()
            row1_col3.background = getColor(R.color.dark_purple).toDrawable()

            row2_col1.background = getColor(R.color.dark_purple).toDrawable()
            row2_col2.background = getColor(R.color.dark_purple).toDrawable()
            row2_col3.background = getColor(R.color.dark_purple).toDrawable()

            row3_col1.background = getColor(R.color.dark_purple).toDrawable()
            row3_col2.background = getColor(R.color.dark_purple).toDrawable()
            row3_col3.background = getColor(R.color.dark_purple).toDrawable()

            val new_arr: Array<Int> = arrayOf(
                0,0,0,
                0,0,0,
                0,0,0)

            board_array =  new_arr
        }//reset game

        val intent = Intent(this, MainActivity::class.java)

        val p1 = getIntent().extras
        val p2 = getIntent().extras

        player1.text = "Player 1"
        player2.text = "Player 2"

        if (p1 != null)
            player1.text = p1.getString("p_name1").toString()
        if (p2 != null)
            player2.text = p2.getString("p_name2").toString()

        val player1_message = Toast.makeText(applicationContext, "${player1.text} Win", Toast.LENGTH_LONG)
        val player2_message = Toast.makeText(applicationContext, "${player2.text} Win", Toast.LENGTH_LONG)
        val nobody_win      = Toast.makeText(applicationContext, "Win Nobody", Toast.LENGTH_LONG)

        var x_score = 0
        var o_score = 0

        back.setOnClickListener{

            intent.putExtra("x_score",x_score.toString())
            intent.putExtra("o_score",o_score.toString())

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

                    when(find_winer(board_array,1)){
                        true -> {
                            x_score++
                            player1_message.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                    }

                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row1_col1.background = getDrawable(R.drawable.o)
                    board_array[0] = 2

                    when(find_winer(board_array,2)){
                        true -> {
                            o_score++
                            player2_message.show()
                            reset_game()
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                        }
                    }//
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

                    when(find_winer(board_array,1)){
                        true -> {
                            x_score++
                            player1_message.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                    }
                }

                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row1_col2.background = getDrawable(R.drawable.o)
                    board_array[1] = 2

                    when(find_winer(board_array,2)){
                        true -> {
                            o_score++
                            player2_message.show()
                            reset_game()
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                        }
                    }//
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

                    when(find_winer(board_array,1)){
                        true -> {
                            x_score++
                            player1_message.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                    }
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row1_col3.background = getDrawable(R.drawable.o)
                    board_array[2] = 2

                    when(find_winer(board_array,2)){
                        true -> {
                            o_score++
                            player2_message.show()
                            reset_game()
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                        }
                    }//
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

                    when(find_winer(board_array,1)){
                        true -> {
                            x_score++
                            player1_message.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                    }
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row2_col1.background = getDrawable(R.drawable.o)
                    board_array[3] = 2

                    when(find_winer(board_array,2)){
                        true -> {
                            o_score++
                            player2_message.show()
                            reset_game()
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                        }
                    }//
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

                        when(find_winer(board_array,1)){
                            true -> {
                                x_score++
                                player1_message.show()
                                reset_game()
                                player1.background = getDrawable(R.drawable.board_background)
                                player2.background = null
                            }
                            null -> {
                                nobody_win.show()
                                reset_game()
                                player1.background = getDrawable(R.drawable.board_background)
                                player2.background = null
                            }
                        }
                    }
                    false -> {
                        player1.background = getDrawable(R.drawable.board_background)
                        player2.background = null

                        row2_col2.background = getDrawable(R.drawable.o)
                        board_array[4] = 2

                        when(find_winer(board_array,2)){
                            true -> {
                                o_score++
                                player2_message.show()
                                reset_game()
                            }
                            null -> {
                                nobody_win.show()
                                reset_game()
                            }
                        }//
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

                    when(find_winer(board_array,1)){
                        true -> {
                            x_score++
                            player1_message.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                    }
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row2_col3.background = getDrawable(R.drawable.o)
                    board_array[5] = 2

                    when(find_winer(board_array,2)){
                        true -> {
                            o_score++
                            player2_message.show()
                            reset_game()
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                        }
                    }//
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

                    when(find_winer(board_array,1)){
                        true -> {
                            x_score++
                            player1_message.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                    }
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row3_col1.background = getDrawable(R.drawable.o)
                    board_array[6] = 2

                    when(find_winer(board_array,2)){
                        true -> {
                            o_score++
                            player2_message.show()
                            reset_game()
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                        }
                    }//
                }
            }
        }

        row3_col2.setOnClickListener{
            if (cheker(board_array,7))
            when(chek_cont_xo(board_array)){
                true  -> {
                    player2.background = getDrawable(R.drawable.board_background)
                    player1.background = null

                    row3_col2.background = getDrawable(R.drawable.x)
                    board_array[7] = 1

                    when(find_winer(board_array,1)){
                        true -> {
                            x_score++
                            player1_message.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                    }
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row3_col2.background = getDrawable(R.drawable.o)
                    board_array[7] = 2

                    when(find_winer(board_array,2)){
                        true -> {
                            o_score++
                            player2_message.show()
                            reset_game()
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                        }
                    }//
                }
            }
        } //

        row3_col3.setOnClickListener{

            if (cheker(board_array,8))
            when(chek_cont_xo(board_array)){
                true  -> {
                    player2.background = getDrawable(R.drawable.board_background)
                    player1.background = null

                    row3_col3.background = getDrawable(R.drawable.x)
                    board_array[8] = 1

                    when(find_winer(board_array,1)){
                        true -> {
                            x_score++
                            player1_message.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                            player1.background = getDrawable(R.drawable.board_background)
                            player2.background = null
                        }
                    }
                }
                false -> {
                    player1.background = getDrawable(R.drawable.board_background)
                    player2.background = null

                    row3_col3.background = getDrawable(R.drawable.o)
                    board_array[8] = 2

                    when(find_winer(board_array,2)){
                        true -> {
                            o_score++
                            player2_message.show()
                            reset_game()
                        }
                        null -> {
                            nobody_win.show()
                            reset_game()
                        }
                    }//
                }
            }
        } //


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

// 0 0 0
// 0 0 0
// 0 0 0

fun find_winer(array: Array<Int>, i:Int):Boolean?{

    var row_1 = false
    var row_2 = false
    var row_3 = false

    var column1 = false
    var column2 = false
    var column3 = false

    var diagonal1 = false
    var diagonal2 = false


    for(j in 0..2){
        if (i == array[j])
            row_1 = true
        else{
            row_1 = false
            break
        }
    }
    for(j in 3..5){
        if (i == array[j])
            row_2 = true
        else{
            row_2 = false
            break
        }
    }
    for(j in 6..8){
        if (i == array[j])
            row_3 = true
        else{
            row_3 = false
            break
        }
    }

    var k = 0
    while(k<=6) {
        if (i == array[k])
            column1 = true
        else{
            column1 = false
            break
        }
        k+=3
    }

    k = 1
    while(k<=7) {
        if (i == array[k])
            column2 = true
        else{
            column2 = false
            break
        }
        k+=3
    }

    k = 2
    while(k<=8) {
        if (i == array[k])
            column3 = true
        else{
            column3 = false
            break
        }
        k+=3
    }

    k = 0
    while(k<=8) {
        if (i == array[k])
            diagonal1 = true
        else{
            diagonal1 = false
            break
        }
        k+=4
    }
    k = 2
    while(k<=6) {
        if (i == array[k])
            diagonal2 = true
        else{
            diagonal2 = false
            break
        }
        k+=2
    }

    val arr = arrayOf(
        row_1,row_2,row_3,
        column1,column2,column3,
        diagonal1,diagonal2
    )


    arr.forEach {
        if (it == true)
            return true
    }

    var count = 0
    array.forEach {
        if (it != 0)
            count++
    }
    if (count == 9)
        return null

    return false
}

