package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.Toast.makeText

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

    }

    private fun rollDice() {

        val randomInt = (1..6).random()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        val edtNumero: EditText = findViewById(R.id.edtNumero)
        val number: Int = edtNumero.text.toString().toInt()
        val txtResultado: TextView = findViewById(R.id.txtResultado)
        if (number < 1 || number > 6){
            txtResultado.text = "Digite um número entre 1 e 6!"
        } else if (randomInt == number) {
            txtResultado.text = "Você ganhou!"
        }else{
            txtResultado.text = "Você perdeu!"

        }

    }
}
