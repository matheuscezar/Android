package com.example.trabalho

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_nota.view.*
import java.util.ArrayList

class AdapterNota(var lista_notas : ArrayList<Nota>) : RecyclerView.Adapter<AdapterNota.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_nota,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return lista_notas.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.notaNome.text = lista_notas.get(position).nome

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var notaNome = itemView.findViewById<TextView>(R.id.lbNota)


    }
}
