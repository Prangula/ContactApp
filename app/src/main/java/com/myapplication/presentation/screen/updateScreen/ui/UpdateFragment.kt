package com.myapplication.presentation.screen.updateScreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.myapplication.R
import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.databinding.FragmentUpdateBinding
import com.myapplication.presentation.screen.contactsScreen.ui.ContactsFragment
import com.myapplication.presentation.screen.updateScreen.vm.UpdateViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class UpdateFragment : Fragment(R.layout.fragment_update) {
    private lateinit var binding: FragmentUpdateBinding
    private val viewModel by viewModel<UpdateViewModel>()
    private lateinit var contactItem: ContactEntity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        contactItem = requireArguments().getParcelable("contactItem")!!
        binding.etNameEditContact.setText(contactItem.name)
        binding.etNumberEditContact.setText(contactItem.number)
        update()

    }

    private fun update() {
        binding.btnPlusSaveContact.setOnClickListener {
            lifecycleScope.launch {
                val name = binding.etNameEditContact.text.toString()
                val number = binding.etNumberEditContact.text.toString()
                if (name == contactItem.name && number == contactItem.number) {
                    navigateToHomeFragment()
                } else if (name.isNotEmpty() && number.isNotEmpty()) {
                    val item = ContactEntity(name, number, id = contactItem.id)
                    viewModel.update(item)
                    navigateToHomeFragment()
                }
            }
        }
    }

    private fun navigateToHomeFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.navHostFragment, ContactsFragment())
            .commit()
    }
}