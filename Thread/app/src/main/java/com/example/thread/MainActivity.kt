package com.example.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

  //     object : Thread(){
  //          override fun run() {
  //              txtTexto.text = "Texto alterado - 1"
  //          }

//        }.start()
//        Thread{
//            txtTexto.text = "Texto Alterado - 2"
//        }
//
//        var handler = Handler()
//        Thread{
//            handler.post{ txtTexto.text = "Texto Alterado - 3"}
//        }.start()

        //runOnUiThread { txtTexto.text = "Texto Alterado - 4" }
    }

    fun processar(v : View){
        txtTexto.text = "Processando..."
        btnProcessar.isEnabled = false;
        executaAlgoDemorado()
        txtTexto.text = "Processamento finalizado"
        btnProcessar.isEnabled= true

    }

    fun executaAlgoDemorado(){
        Thread{
            SystemClock.sleep(5000)
        }.start() 
    }
}
