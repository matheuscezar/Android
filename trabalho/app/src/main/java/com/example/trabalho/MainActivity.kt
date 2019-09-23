package com.example.trabalho

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    var lista_notas : ArrayList<Nota> = ArrayList() // @brief Lista de notas adicionadas


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var adapterNota = AdapterNota(lista_notas)
        //Configurar recycler view
        var recyclerView: RecyclerView
        var layoutManager : LinearLayoutManager
        recyclerView = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapterNota




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { //@brief Inflando o menu
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean { // @brief Action do menu

        if (item?.itemId == R.id.menuButton) {
            Toast.makeText(this, "Chamando action of button", Toast.LENGTH_SHORT).show()
            intent = Intent(this,Edit::class.java)
            startActivityForResult(intent,10)
            return true
        }else{
            return super.onOptionsItemSelected(item)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { //@brief Result da activity
        super.onActivityResult(requestCode, resultCode, data)
       if(resultCode == Activity.RESULT_OK) {
           criarNota(data!!.getStringExtra("NomeNota"), data!!.getStringExtra("CorpoNota"))
           Toast.makeText(
               this,
               "Crindo nota: " + data.getStringExtra("NomeNota"),
               Toast.LENGTH_SHORT
           ).show()
       }
    }

    fun criarNota(nome : String, corpo : String){
        var nota = Nota(nome, corpo)
        lista_notas?.add(nota)

    }


}




