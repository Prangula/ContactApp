package com.myapplication.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.myapplication.R
import com.myapplication.data.database.ContactDatabase
import com.myapplication.data.database.ContactItem
import com.myapplication.data.repository.ContactRepositoryImpl
import com.myapplication.databinding.FragmentEditBinding
import com.myapplication.domain.use_cases.UpdateUseCase
import com.myapplication.presentation.viewmodel.UpdateViewModel
import com.myapplication.presentation.viewmodel.UpdateViewModelFactory
import kotlinx.coroutines.launch

class EditFragment : Fragment(R.layout.fragment_edit) {
    private lateinit var binding: FragmentEditBinding
    private lateinit var viewModel: UpdateViewModel
    private lateinit var contactItem: ContactItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = ContactDatabase(requireActivity())
        val repositoryImpl = ContactRepositoryImpl(database)
        val updateUseCase = UpdateUseCase(repositoryImpl)
        val factory = UpdateViewModelFactory(updateUseCase)
        viewModel = ViewModelProvider(requireActivity(), factory).get(UpdateViewModel::class.java)

        contactItem = requireArguments().getParcelable<ContactItem>("contactItem")!!
        binding.etNameEditContact.setText(contactItem!!.name)
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
                    val item = ContactItem(name, number, id = contactItem.id)
                    viewModel.update(item)
                    navigateToHomeFragment()
                }
            }
        }
    }

    private fun navigateToHomeFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.navHostFragment, HomeFragment())
            .commit()
    }
}