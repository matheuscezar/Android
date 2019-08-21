package com.example.aulaadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), AlimentoListFragment.OnItemClickAlimento {

    private var textFragment : TextFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textFragment = supportFragmentManager.findFragmentById(R.id.frag_text) as TextFragment
    }

    override fun onClick(alimento: Alimento) {
        textFragment?.setMsgText("O preco do ${alimento} é R$ ${alimento.preco}")
    }
}
