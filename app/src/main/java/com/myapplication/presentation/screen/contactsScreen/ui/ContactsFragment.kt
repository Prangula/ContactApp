package com.myapplication.presentation.screen.contactsScreen.ui

import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.databinding.FragmentContactsBinding
import com.myapplication.presentation.base.BaseFragment
import com.myapplication.presentation.model.ContactUi
import com.myapplication.presentation.screen.contactsScreen.adapter.ContactsAdapter
import com.myapplication.presentation.screen.contactsScreen.vm.ContactsViewModel
import com.myapplication.utils.observe
import kotlin.reflect.KClass

class ContactsFragment :
    BaseFragment<FragmentContactsBinding, ContactsViewModel>(
        FragmentContactsBinding::inflate
    ) {
    private lateinit var adapter: ContactsAdapter
    override val viewModelClass: KClass<ContactsViewModel> = ContactsViewModel::class

    override fun onBind() {
        rvContacts()
        observer()
        navigateToAddFragment()
    }

    private fun rvContacts() {
        with(binding) {
            adapter = ContactsAdapter(
                { item ->
                    navigateToEditFragment(item)
                }
            ) { item ->
                deleteCustomView.delete(item) {
                    viewModel.delete(item)
                }
            }
            rvContact.adapter = adapter
            rvContact.apply {
                layoutManager = LinearLayoutManager(requireActivity())
            }
        }
    }

    private fun observer() {
        lifecycleScope.launchWhenStarted {
            viewModel.contacts.collect { item ->
                adapter.submitList(item)
            }
        }
        observe(viewModel.emptyContacts) { emptyContacts ->
            if (emptyContacts) {
                binding.rvContact.visibility = View.GONE
                binding.noContacts.visibility = View.VISIBLE
            } else {
                binding.rvContact.visibility = View.VISIBLE
                binding.noContacts.visibility = View.GONE
            }
        }
    }

    private fun navigateToAddFragment() {
        binding.btnAddContact.setOnClickListener {
            viewModel.navigateToAddFragment()
        }
    }

    private fun navigateToEditFragment(contactUi: ContactUi) {
        viewModel.navigateToEditFragment(contactUi)
    }
}