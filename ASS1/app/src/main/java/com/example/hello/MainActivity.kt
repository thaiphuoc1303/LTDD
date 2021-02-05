package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.rollButton)
        val diceImage1: ImageView = findViewById(R.id.dice_image1)
        val diceImage2: ImageView = findViewById(R.id.dice_image2)
        val diceImage3: ImageView = findViewById(R.id.dice_image3)

        val point : TextView = findViewById(R.id.point)
        rollButton.setOnClickListener(){
            val randomInt1 = (1..6).random()
            val randomInt2 = (1..6).random()
            val randomInt3 = (1..6).random()
            var s: Int =randomInt1+ randomInt2 + randomInt3
            val drawableResource1 = when (randomInt1) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            val drawableResource2 = when (randomInt2) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            val drawableResource3 = when (randomInt3) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            point.text = s.toString()
            diceImage1.setImageResource(drawableResource1)
            diceImage2.setImageResource(drawableResource2)
            diceImage3.setImageResource(drawableResource3)
        }
        var a: Int = 10
        var b : Int = 31
        if (a<b){
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
        }
    }
}