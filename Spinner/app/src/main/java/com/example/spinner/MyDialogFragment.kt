package com.example.spinner

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Toast

class MyDialogFragment : DialogFragment(), DialogInterface.OnClickListener{
    override fun onClick(dialog: DialogInterface?, which: Int) {
        var msg : String? = null

        if(which == DialogInterface.BUTTON_POSITIVE){
            msg = "Você clicou em sim"
        }else if(which == DialogInterface.BUTTON_NEGATIVE){
            msg = "Você clicou em não"
        }
        Toast.makeText(requireActivity(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
            .setTitle("Pergunta")
            .setMessage("Você entendeu como funciona Dialog")
            .setPositiveButton("Sim", this)
            .setNegativeButton("Não", this)

        return builder.create()

    }
}