package com.myapplication.utils

import android.app.Dialog
import android.content.Context
import android.widget.TextView
import com.myapplication.R
import com.myapplication.presentation.model.ContactUi
import com.myapplication.presentation.screen.contactsScreen.vm.ContactsViewModel

class DeleteDialog(
    private val contactUi: ContactUi,
    private val context: Context,
    private val viewModel: ContactsViewModel
) {
    operator fun invoke() {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.alert_dialog)
        dialog.setCancelable(false)

        val name = dialog.findViewById<TextView>(R.id.alertName)
        val yes = dialog.findViewById<TextView>(R.id.yes_alert)
        val no = dialog.findViewById<TextView>(R.id.no_alert)
        name.text = contactUi.name

        yes.setOnClickListener {
            viewModel.delete(contactUi)
            dialog.dismiss()
        }
        no.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}