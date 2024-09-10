package com.myapplication.presentation.screen.contactsScreen.ui

import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.databinding.FragmentContactsBinding
import com.myapplication.presentation.base.BaseFragment
import com.myapplication.presentation.model.ContactUi
import com.myapplication.presentation.screen.contactsScreen.adapter.ContactsAdapter
import com.myapplication.presentation.screen.contactsScreen.vm.ContactsViewModel
import com.myapplication.utils.DeleteDialog
import com.myapplication.utils.emptyObserve
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
        adapter = ContactsAdapter(
            { items ->
                navigateToEditFragment(items)
            },
            { item ->
                DeleteDialog(item, requireActivity(), viewModel).invoke()
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
            }
        }
        emptyObserve(viewModel.emptyContacts) { emptyContacts ->
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
            val action = ContactsFragmentDirections.actionHomeFragmentToAddFragment()
            viewModel.navController(action)
        }
    }

    private fun navigateToEditFragment(items: ContactUi) {
        val action = ContactsFragmentDirections.actionHomeFragmentToEditFragment(items)
        viewModel.navController(action)
    }
}