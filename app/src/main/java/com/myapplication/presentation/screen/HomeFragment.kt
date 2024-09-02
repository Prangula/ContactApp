package com.myapplication.presentation.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.R
import com.myapplication.data.database.ContactDatabase
import com.myapplication.data.database.ContactItem
import com.myapplication.data.repository.ContactRepositoryImpl
import com.myapplication.databinding.FragmentHomeBinding
import com.myapplication.domain.use_cases.ContactsUseCase
import com.myapplication.presentation.adapter.ContactsAdapter
import com.myapplication.presentation.viewmodel.ContactsViewModel
import com.myapplication.presentation.viewmodel.ContactsViewModelFactory

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ContactsAdapter
    private lateinit var viewModel: ContactsViewModel
    private val items: ArrayList<ContactItem> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = ContactDatabase(requireActivity())
        val repositoryImpl = ContactRepositoryImpl(database)
        val contactsUseCase = ContactsUseCase(repositoryImpl)
        val factory = ContactsViewModelFactory(contactsUseCase)
        viewModel = ViewModelProvider(requireActivity(), factory).get(ContactsViewModel::class.java)
        rvContacts(items)
        observer()
        navigateToAddFragment()
    }

    private fun rvContacts(items: ArrayList<ContactItem>) {
        adapter = ContactsAdapter(items)
        binding.rvContact.adapter = adapter
        binding.rvContact.apply {
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observer() {
        lifecycleScope.launchWhenStarted {
            viewModel.contacts.collect { item ->
                items.clear()
                items.addAll(item)
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun navigateToAddFragment() {
        binding.btnAddContact.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.navHostFragment, AddFragment())
                .commit()
        }
    }
}