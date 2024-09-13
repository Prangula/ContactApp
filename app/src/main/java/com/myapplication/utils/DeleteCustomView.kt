package com.myapplication.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import com.myapplication.databinding.AlertDialogBinding
import com.myapplication.presentation.model.ContactUi

@SuppressLint("ViewConstructor")
class DeleteCustomView @JvmOverloads constructor(
    context: Context,
) : Dialog(context) {
    private val binding = AlertDialogBinding.inflate(layoutInflater)

    fun delete(contactUi: ContactUi, deleteClickedYes: () -> Unit) {
        val dialog = Dialog(context)
        dialog.setContentView(binding.root)
        dialog.setCancelable(false)

        with(binding) {
            alertName.text = contactUi.name
            yesAlert.setOnClickListener {
                deleteClickedYes.invoke()
                dialog.dismiss()
            }
            noAlert.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}