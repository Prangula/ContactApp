package com.myapplication.presentation.screen.updateScreen.ui

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.myapplication.databinding.FragmentUpdateBinding
import com.myapplication.presentation.base.BaseFragment
import com.myapplication.presentation.model.ContactUi
import com.myapplication.presentation.screen.updateScreen.vm.UpdateViewModel
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class UpdateFragment : BaseFragment<FragmentUpdateBinding, UpdateViewModel>(
    FragmentUpdateBinding::inflate
) {
    private lateinit var contactItem: ContactUi
    private val args: UpdateFragmentArgs by navArgs()
    override val viewModelClass: KClass<UpdateViewModel>
        get() = UpdateViewModel::class

    override fun onBind() {
        contactItem = args.contact
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
                    val item = ContactUi(name, number, id = contactItem.id)
                    viewModel.update(item)
                    navigateToHomeFragment()
                }
            }
        }
    }

    private fun navigateToHomeFragment() {
        viewModel.navigateBack()
    }
}