package com.example.projectfragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_text.*
import java.lang.RuntimeException

class TextFragment : Fragment() {

    var myListener: OnInverterListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(!(context is OnInverterListener)){
                throw RuntimeException("Não é um OnInvertListener")
            }
        myListener = context as OnInverterListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var myView: View = inflater.inflate(R.layout.fragment_text, container, false)

        var btnInverter = myView.findViewById<Button>(R.id.btnInverter)

            btnInverter.setOnClickListener{
                if(myListener != null){
                    var texto = edt_texto.text.toString()
                    myListener?.onInvert(texto)
                }
        }

        return myView

    }

    interface OnInverterListener{
        fun onInvert(text: String):Unit
    }
}