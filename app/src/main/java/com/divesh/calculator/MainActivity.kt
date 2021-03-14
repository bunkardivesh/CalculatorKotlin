package com.divesh.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var tvZero : TextView? = null
    var tvOne : TextView? = null
    var tvTwo : TextView? = null
    var tvThree : TextView? = null
    var tvFour : TextView? = null
    var tvFive : TextView? = null
    var tvSix : TextView? = null
    var tvSeven : TextView? = null
    var tvEight : TextView? = null
    var tvNine : TextView? = null

    var tvExpression : TextView? = null
    var tvClear : TextView? = null
    var tvDelete : TextView? = null
    var tvEquals : TextView? = null
    var tvResult : TextView? = null

    var tvPlus : TextView? = null
    var tvMinus : TextView? = null
    var tvMul : TextView? = null
    var tvDiv : TextView? = null


    var expression : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvZero = findViewById(R.id.tvZero) as TextView
        tvOne = findViewById(R.id.tvOne) as TextView
        tvTwo = findViewById(R.id.tvTwo) as TextView
        tvThree = findViewById(R.id.tvThree) as TextView
        tvFour = findViewById(R.id.tvFour) as TextView
        tvFive = findViewById(R.id.tvFive) as TextView
        tvSix = findViewById(R.id.tvSix) as TextView
        tvSeven = findViewById(R.id.tvSeven) as TextView
        tvEight = findViewById(R.id.tvEight) as TextView
        tvNine = findViewById(R.id.tvNine) as TextView

        tvExpression = findViewById(R.id.tvExpression) as TextView
        tvClear = findViewById(R.id.tvClear) as TextView
        tvDelete = findViewById(R.id.tvDelete) as TextView
        tvEquals = findViewById(R.id.tvEquals) as TextView
        tvResult = findViewById(R.id.tvResult) as TextView

        tvPlus = findViewById(R.id.tvPlus) as TextView
        tvMinus = findViewById(R.id.tvMinus) as TextView
        tvMul = findViewById(R.id.tvMul) as TextView
        tvDiv = findViewById(R.id.tvDiv) as TextView



        tvZero!!.setOnClickListener{
            eveluateExpression("0",true)
        }

        tvOne!!.setOnClickListener{
            eveluateExpression("1",true)
        }

        tvTwo!!.setOnClickListener{
            eveluateExpression("2",true)
        }

        tvThree!!.setOnClickListener{
            eveluateExpression("3",true)
        }

        tvFour!!.setOnClickListener{
            eveluateExpression("4",true)
        }

        tvFive!!.setOnClickListener{
            eveluateExpression("5",true)
        }

        tvSix!!.setOnClickListener{
            eveluateExpression("6",true)
        }

        tvSeven!!.setOnClickListener{
            eveluateExpression("7",true)
        }

        tvEight!!.setOnClickListener{
            eveluateExpression("8",true)
        }

        tvNine!!.setOnClickListener{
            eveluateExpression("9",true)
        }

        tvPlus!!.setOnClickListener{
            eveluateExpression("+",true)
        }

        tvMinus!!.setOnClickListener{
            eveluateExpression("-",true)
        }

        tvMul!!.setOnClickListener{
            eveluateExpression("*",true)
        }

        tvDiv!!.setOnClickListener{
            eveluateExpression("/",true)
        }




        tvClear!!.setOnClickListener{
            tvExpression!!.setText("")
            tvResult!!.setText("")
            expression = ""
        }

        tvDelete!!.setOnClickListener {
            val text = tvExpression!!.text.toString()
            if (text.isNotEmpty()) {
                var newText = text.substring(0,text.length-1)
                tvExpression!!.text = newText
                expression = newText
            }
        }

     /*   tvDelete!!.setOnLongClickListener{

        }*/

        tvEquals!!.setOnClickListener{
            val text = tvExpression!!.text.toString()
            val expression = ExpressionBuilder(text).build()

            try {
                val result = expression.evaluate()
                val longResult = result.toLong()

                if (result == longResult.toDouble()){
                    tvResult!!.text = longResult.toString()
                }else{
                    tvResult!!.text = result.toString()
                }
            }catch (e : Exception){
                tvResult!!.setText(e.message)
            }

        }

    }

    fun eveluateExpression(string: String, clear:Boolean){

        if (clear){
                    expression = expression + string
                    tvExpression!!.setText(expression)
        }else{

        }
    }

}