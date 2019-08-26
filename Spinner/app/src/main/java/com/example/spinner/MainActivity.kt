package com.example.spinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var adapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item)

        adapter?.add("Natal")
        adapter?.add("Parnamirim")
        adapter?.add("Macaíba")
        adapter?.add("Brejinho")
        adapter?.add("Caicó")

        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_item)

        spinner.adapter = adapter
        spinner.setOnItemSelectedListener(this)


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var cidade : String? = adapter?.getItem(position).toString()
        Toast.makeText(this, cidade, Toast.LENGTH_SHORT).show()
    }

    fun open(view : View){
        var dialog = MyDialogFragment()
        dialog.show(supportFragmentManager, "dialog")
    }

    fun openSimple(view : View){
        var dialog = SimpleDialogFragment()
        dialog.show(supportFragmentManager, "dialog")
    }
}
