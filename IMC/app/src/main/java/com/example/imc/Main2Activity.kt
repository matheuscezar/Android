package com.example.imc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

var peso : String? = null
var altura : String? = null

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = Intent(this, MainActivity::class.java)
    }

    override fun onStart(){
        super.onStart()
        if(intent.getStringExtra("tipo")=="Peso"){
            var unidade = findViewById<TextView>(R.id.unidade)
            unidade.text = "kg"
        }
        if(intent.getStringExtra("tipo")=="Altura"){
            var unidade = findViewById<TextView>(R.id.unidade)
            unidade.text = "cm"
        }

    }

    fun alterar(view : View){
        if(intent.getStringExtra("tipo")=="Peso") {
            peso = findViewById<EditText>(R.id.edtValor).text.toString()
            intent.putExtra("Peso", peso)
        }
        if(intent.getStringExtra("tipo")=="Altura") {
            altura = findViewById<EditText>(R.id.edtValor).text.toString()
            intent.putExtra("Peso", altura)
        }
    }

    fun cancelar(view: View){
        startActivity(intent)
    }
}

