package com.example.spinner

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Toast

class SimpleDialogFragment : DialogFragment(), DialogInterface.OnClickListener {
    override fun onClick(dialog: DialogInterface?, which: Int) {
        val linguagens = requireActivity()
            .resources.getStringArray(R.array.linguagens)
        val linguagem = linguagens[which]

        Toast.makeText(requireActivity(), linguagem, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("Escolha uma linguagem")
            .setItems(R.array.linguagens, this)
            .create()
    }
}