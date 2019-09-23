package com.example.trabalho

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import android.R
import android.view.View


class SaveDialog:DialogFragment() {

    var dialogViewTemplate : View?=null



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        builder.setView(dialogViewTemplate)
        builder.setTitle("Digite o nome da nota")
        builder.setMessage("Qual o nome da nota?")


        return builder.create()
    }
}