package com.myapplication.presentation.screen.contactsScreen.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.R
import com.myapplication.databinding.FragmentContactsBinding
import com.myapplication.presentation.model.ContactUi
import com.myapplication.presentation.screen.contactsScreen.adapter.ContactsAdapter
import com.myapplication.presentation.screen.contactsScreen.vm.ContactsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactsFragment : Fragment(R.layout.fragment_contacts) {
    private lateinit var binding: FragmentContactsBinding
    private lateinit var adapter: ContactsAdapter
    private val viewModel by viewModel<ContactsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvContacts()
        observer()
        navigateToAddFragment()
    }

    private fun rvContacts() {
        adapter = ContactsAdapter(
            { items ->
                navigateToEditFragment(items)
            },
            { item ->
                deleteDialog(item)
            }
        )
        binding.rvContact.adapter = adapter
        binding.rvContact.apply {
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    private fun observer() {
        lifecycleScope.launchWhenStarted {
            viewModel.contacts.collect { item ->
                adapter.submitList(item)
                viewModel.rvVisibility(binding.rvContact, binding.noContacts)
            }
        }
    }

    private fun navigateToAddFragment() {
        binding.btnAddContact.setOnClickListener {
            val action = ContactsFragmentDirections.actionHomeFragmentToAddFragment()
            findNavController().navigate(action)
        }
    }

    private fun navigateToEditFragment(items: ContactUi) {
        val action = ContactsFragmentDirections.actionHomeFragmentToEditFragment(items)
        findNavController().navigate(action)
    }

    private fun deleteDialog(item: ContactUi) {
        val dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.alert_dialog)
        dialog.setCancelable(false)

        val name = dialog.findViewById<TextView>(R.id.alertName)
        val yes = dialog.findViewById<TextView>(R.id.yes_alert)
        val no = dialog.findViewById<TextView>(R.id.no_alert)
        name.text = item.name

        yes.setOnClickListener {
            // es am viewmodelshi unda gadmovitano
            viewModel.delete(item)
            dialog.dismiss()
        }
        no.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}