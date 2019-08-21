package com.example.aulaadapter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.ListFragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import java.lang.RuntimeException


class AlimentoListFragment : ListFragment() {

    private var listener : OnItemClickAlimento? = null
    private var adapter : ArrayAdapter<Alimento>? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context !is OnItemClickAlimento){
            throw RuntimeException("Não é OnItemClickAlimento")
        }
        listener = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1)
        var nomes = requireActivity().resources.getStringArray(R.array.alimentos_nomes)
        var precos = requireActivity().resources.getStringArray(R.array.alimentos_precos)

        for (i in nomes.indices){
            val alimento = Alimento(nomes[i], precos[i].toDouble())
            adapter?.add(alimento)
        }

        listAdapter = adapter
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        var alimento = adapter?.getPosition(position!!)
        listener?.onClick(alimento!!)
    }

    interface OnItemClickAlimento{
        fun onClick(alimento: Alimento)
    }

}

