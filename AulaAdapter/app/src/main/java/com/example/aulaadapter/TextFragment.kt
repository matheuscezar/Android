package com.example.aulaadapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TextFragment : Fragment() {

    private var txtMsg : TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_text, container, false)
        txtMsg = v.findViewById(R.id.txt_Msg)
        return v
    }

    fun setMsgText(text : String){
        txtMsg?.text = text
    }
}