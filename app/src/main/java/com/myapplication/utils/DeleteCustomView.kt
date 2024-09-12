package com.myapplication.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.myapplication.R
import com.myapplication.databinding.AlertDialogBinding
import com.myapplication.presentation.model.ContactUi
import com.myapplication.presentation.screen.contactsScreen.vm.ContactsViewModel

@SuppressLint("ViewConstructor")
class DeleteCustomView @JvmOverloads constructor(
    context: Context,
) : Dialog(context) {
    private val binding = AlertDialogBinding.inflate(layoutInflater)

    fun delete(contactUi: ContactUi, deleteClickedYes: () -> Unit) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.alert_dialog)
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