package com.example.calculater_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
var isnewop=true
var oldNumber=""
 var op="+ "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if(isnewop)
            editTextT.setText("")
        isnewop=false
        var btnclick=editTextT.text.toString()
        var btnselect= view as Button
        when(btnselect.id) {
            btn0.id -> {btnclick += "0"}
            btn1.id -> {btnclick += "1"}
            btn2.id -> {btnclick += "2"}
            btn3.id -> {btnclick += "3"}
            btn4.id -> {btnclick += "4"}
            btn5.id -> {btnclick += "5"}
            btn6.id -> {btnclick += "6"}
            btn7.id -> {btnclick += "7"}
            btn8.id -> {btnclick += "8"}
            btn9.id -> {btnclick += "9"}
            btn_float.id -> {btnclick += "."}
            btn_sign.id -> {var length=btnclick.length
                if(btnclick.startsWith("-")) btnclick=btnclick.subSequence(1,length).toString()
                else btnclick="-$btnclick"}
        }
        editTextT.setText(btnclick)
    }

    fun operatorEvent(view: View) {
        isnewop=true
        oldNumber=editTextT.text.toString()
        var btnselect= view as Button
        when(btnselect.id){
            btn_multi.id ->{op="*"}
            btn_add.id ->{op="+"}
            btn_min.id ->{op="-"}
            btn_div.id ->{op="/"}
        }

    }

    fun equalEvent(view: View) {
        var newNumber=editTextT.text.toString()
        var result=0.0
        when(op){
            "+" -> {result=oldNumber.toDouble()+ newNumber.toDouble()}
            "-" -> {result=oldNumber.toDouble()- newNumber.toDouble()}
            "*" -> {result=oldNumber.toDouble()* newNumber.toDouble()}
            "/" -> {
            if (newNumber.toInt()==0){
                Toast.makeText(applicationContext, "can't devide by Zero", Toast.LENGTH_SHORT).show()
                //editTextT.setText(result.toString())
            }
            else{
            result=oldNumber.toDouble()/ newNumber.toDouble()
            }}
        }
        editTextT.setText(result.toString())
    }

    fun acEvent(view: View) {
        editTextT.setText("0")
        isnewop=true
    }

    fun deleteEvent(view: View) {
       val length= editTextT.length()
        if(length>0)
            editTextT.text= editTextT.text.subSequence(0,length-1) as Editable?
    }

}