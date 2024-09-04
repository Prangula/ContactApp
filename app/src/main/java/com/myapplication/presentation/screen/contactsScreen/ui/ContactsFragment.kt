package com.myapplication.presentation.screen.contactsScreen.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.R
import com.myapplication.databinding.FragmentContactsBinding
import com.myapplication.presentation.screen.contactsScreen.adapter.ContactsAdapter
import com.myapplication.presentation.screen.insertScreen.ui.InsertFragment
import com.myapplication.presentation.screen.updateScreen.ui.UpdateFragment
import com.myapplication.presentation.screen.contactsScreen.vm.ContactsViewModel
import com.myapplication.presentation.screen.deleteVm.DeleteViewModel
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
        navigateToEditFragment()
        deleteDialog()
    }

    private fun rvContacts() {
        adapter = ContactsAdapter()
        binding.rvContact.adapter = adapter
        binding.rvContact.apply {
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observer() {
        lifecycleScope.launchWhenStarted {
            viewModel.contacts.collect { item ->
                adapter.submitList(item)
                adapter.notifyDataSetChanged()
                /*
                if (items.size > 0) {
                    binding.rvContact.visibility = View.VISIBLE
                    binding.noContacts.visibility = View.GONE
                } else {
                    binding.rvContact.visibility = View.GONE
                    binding.noContacts.visibility = View.VISIBLE
                }

                 */
            }
        }
    }

    private fun navigateToAddFragment() {
        binding.btnAddContact.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.navHostFragment, InsertFragment())
                .commit()
        }
    }

    private fun navigateToEditFragment() {
        adapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putParcelable("contactItem", it)
            }
            val updateFragment = UpdateFragment()
            updateFragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.navHostFragment, updateFragment)
                .commit()
        }
    }

    private fun deleteDialog() {

        val deleteViewModel by viewModel<DeleteViewModel>()

        adapter.setOnLongItemClickListener { item ->
            val dialog = Dialog(requireActivity())
            dialog.setContentView(R.layout.alert_dialog)
            dialog.setCancelable(false)

            val name = dialog.findViewById<TextView>(R.id.alertName)
            val yes = dialog.findViewById<TextView>(R.id.yes_alert)
            val no = dialog.findViewById<TextView>(R.id.no_alert)
            name.text = item.name

            yes.setOnClickListener {
                deleteViewModel.delete(item)
                dialog.dismiss()
            }
            no.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}