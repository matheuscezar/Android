package com.example.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var pref : SharedPreferences? = null
    private var edit : SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         pref = getSharedPreferences("preferences",0)
         edit = pref?.edit()

    }

    fun save(view: View){
        edit?.putString("nome",edtNome.text.toString())
        edit?.putString("email",edtEmail.text.toString())
        edit?.commit()
        Toast.makeText(this,"Salvando os dados", Toast.LENGTH_SHORT).show()
    }

    fun carregar(view: View){
        txtNome.text = pref?.getString("nome".toString(),null)
        txtEmail.text = pref?.getString("email".toString(),null)
        Toast.makeText(this,"Carregando os dados", Toast.LENGTH_SHORT).show()
    }

}
