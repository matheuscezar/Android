package com.example.bancp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private fun  callback (produto : Produto)  {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var banco = SQLiteRepository(applicationContext)
        val p1 = Produto(0L,"Teste nome",1.50f)
        banco.save(p1)
        banco.search(0L, callback(produto))
    }
}
