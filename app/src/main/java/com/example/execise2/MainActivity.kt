package com.example.execise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            if (TextUtils.isEmpty(weight.getText())||TextUtils.isEmpty(height.getText())){
                Toast.makeText(this, R.string.input_error, Toast.LENGTH_SHORT).show()
            }else{
                calcuBMI(it)
            }
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            btnRe(it)
        }
    }

    private fun calcuBMI(view: View){
        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)
        val img = findViewById<ImageView>(R.id.imageViewProfile)
        val bmi = weight.text.toString().toDouble()/(height.text.toString().toDouble()/100*height.text.toString().toDouble()/100)
        val txt = findViewById<TextView>(R.id.textViewBMI)

        val decF = DecimalFormat("###.####")
        txt.text = decF.format(bmi)
        when{
            bmi<18.5 ->img.setBackgroundResource(R.drawable.under)
            bmi>24.9->img.setBackgroundResource(R.drawable.over)
            else -> img.setBackgroundResource(R.drawable.normal)
        }
    }
    private fun btnRe(view: View){

        findViewById<EditText>(R.id.editTextWeight).setText("")
        findViewById<EditText>(R.id.editTextHeight).setText("")
        findViewById<ImageView>(R.id.imageViewProfile).setBackgroundResource(R.drawable.empty)
        findViewById<TextView>(R.id.textViewBMI).setText("")

    }
}
