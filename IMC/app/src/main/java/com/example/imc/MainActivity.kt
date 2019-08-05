package com.example.imc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


var tipo : String = "vazio"
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setPeso(view : View){
        tipo = "Peso"
        val intent = Intent(this, Main2Activity::class.java)
        intent.putExtra("tipo", tipo)
        startActivity(intent)
    }
    fun setAltura(view : View){
        tipo = "Peso"
        val intent = Intent(this, Main2Activity::class.java)
        intent.putExtra("tipo", tipo)
        startActivity(intent)
    }
    fun calcular(view : View){
        var peso = intent.getStringExtra("Peso").toString().toBigDecimal()
        var altura = intent.getStringExtra("Altura").toString().toBigDecimal()
        var resultado = peso / altura * altura
        var auxResultado = findViewById<TextView>(R.id.txtResultado)
        auxResultado.text = resultado.toString()
    }
}
