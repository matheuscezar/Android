package com.example.adapterviewholder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val (modelo, ano) = veiculos[position]
        Toast.makeText(this, "$modelo - $ano", Toast.LENGTH_SHORT)

        veiculos.remove(veiculos[position])
        adapter.notifyDataSetChanged()
    }

    private val veiculos = mutableListOf(
        Veiculo("Onix", 2010, 1, true, true),
        Veiculo("Uno", 2007, 2, true, false),
        Veiculo("Del Rey", 1998, 3, false, true),
        Veiculo("Gol", 2014, 0, true, true),
        Veiculo("Uno", 2007, 2, true, false),
        Veiculo("Del Rey", 1998, 3, false, true),
        Veiculo("Gol", 2014, 0, true, true),        Veiculo("Onix", 2010, 1, true, true),
        Veiculo("Uno", 2007, 2, true, false),
        Veiculo("Del Rey", 1998, 3, false, true),
        Veiculo("Gol", 2014, 0, true, true) ,       Veiculo("Onix", 2010, 1, true, true),
        Veiculo("Uno", 2007, 2, true, false),
        Veiculo("Del Rey", 1998, 3, false, true),
        Veiculo("Gol", 2014, 0, true, true)

    )

    private lateinit var adapter: VeiculoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        var listView = ListView(this)
        setContentView(listView)
        adapter = VeiculoAdapter(this, veiculos)
        listView.adapter = adapter
        listView.setOnItemClickListener(this)

    }
}
