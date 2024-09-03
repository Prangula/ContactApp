package com.myapplication.presentation.screen

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.R
import com.myapplication.data.database.database.ContactDatabase
import com.myapplication.data.database.entity.ContactEntity
import com.myapplication.data.repository.ContactRepositoryImpl
import com.myapplication.databinding.FragmentHomeBinding
import com.myapplication.domain.use_cases.ContactsUseCase
import com.myapplication.domain.use_cases.DeleteUseCase
import com.myapplication.presentation.adapter.ContactsAdapter
import com.myapplication.presentation.viewmodel.ContactsViewModel
import com.myapplication.presentation.viewmodel.ContactsViewModelFactory
import com.myapplication.presentation.viewmodel.DeleteViewModel
import com.myapplication.presentation.viewmodel.DeleteViewModelFactory

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ContactsAdapter
    private lateinit var viewModel: ContactsViewModel
    private val items: ArrayList<ContactEntity> = ArrayList()

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
        navigateToEditFragment()
        deleteDialog()
    }

    private fun rvContacts(items: ArrayList<ContactEntity>) {
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
                if (items.size > 0) {
                    binding.rvContact.visibility = View.VISIBLE
                    binding.noContacts.visibility = View.GONE
                } else {
                    binding.rvContact.visibility = View.GONE
                    binding.noContacts.visibility = View.VISIBLE
                }
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

    private fun navigateToEditFragment() {
        adapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putParcelable("contactItem", it)
            }
            val editFragment = EditFragment()
            editFragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.navHostFragment, editFragment)
                .commit()
        }
    }

    private fun deleteDialog() {

        val database = ContactDatabase(requireActivity())
        val repositoryImpl = ContactRepositoryImpl(database)
        val deleteUseCase = DeleteUseCase(repositoryImpl)
        val factory = DeleteViewModelFactory(deleteUseCase)
        val deleteViewModel =
            ViewModelProvider(requireActivity(), factory).get(DeleteViewModel::class.java)

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