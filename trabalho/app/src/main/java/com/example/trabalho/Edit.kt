package com.example.trabalho

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.dialog.*
import org.w3c.dom.Text

class Edit : AppCompatActivity() {

    val dialog = SaveDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
    }

    fun save(view: View) {

        val lay = layoutInflater.inflate(R.layout.dialog,null)
        dialog.dialogViewTemplate = lay
        dialog.show(supportFragmentManager, "SaveDialog")
    }

    fun saveNomeNota(view : View) {
        val i = intent
        var nomeNota : String? = null
        var corpoNota : String? = null
        var editTexto : EditText? = null
        editTexto = dialog.dialogViewTemplate?.findViewById<EditText>(R.id.edtNomeNota)
        nomeNota = editTexto?.text.toString()
        editTexto = findViewById<EditText>(R.id.edtCorpoNota)
        corpoNota = editTexto?.text.toString()
        Toast.makeText(this, "Salvando nota: "+nomeNota, Toast.LENGTH_SHORT).show()
        i.putExtra("NomeNota", nomeNota)
        i.putExtra("CorpoNota",corpoNota)
        setResult(Activity.RESULT_OK,i)
        finish()

    }
    fun cancel(view: View) {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

}
