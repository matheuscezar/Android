package com.example.actionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actions,menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun toast(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if(id == R.id.action_download){
            toast("Download")
            return true
        }else if(id == R.id.action_add){
            toast("Adicionar")
            return true
        }else if(id == R.id.action_open){
            toast("Abrir")
            return true
        }else{
            return super.onOptionsItemSelected(item)
        }

    }

    fun next(view: View) {
        startActivity(Intent(this,Main2Activity::class.java))
    }
}
