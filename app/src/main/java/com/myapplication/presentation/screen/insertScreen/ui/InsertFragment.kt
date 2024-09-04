package com.myapplication.presentation.screen.insertScreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.myapplication.R
import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.databinding.FragmentInsertBinding
import com.myapplication.presentation.screen.contactsScreen.ui.ContactsFragment
import com.myapplication.presentation.screen.insertScreen.vm.InsertViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class InsertFragment : Fragment(R.layout.fragment_insert) {

    private lateinit var binding: FragmentInsertBinding
    private val viewModel by viewModel<InsertViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInsertBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        insert()
    }

    private fun insert() {
        binding.btnPlusAddContact.setOnClickListener {
            lifecycleScope.launch {
                with(binding) {
                    val name = etNameAddContact.text.toString()
                    val number = etNumberAddContact.text.toString()
                    if (name.isNotEmpty() && number.isNotEmpty()) {
                        val item = ContactEntity(name, number)
                        viewModel.insert(item)
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.navHostFragment, ContactsFragment())
                            .commit()
                    } else {
                        etInput1AddContact.background =
                            ContextCompat.getDrawable(
                                requireActivity(),
                                R.drawable.et_drawable_red
                            )
                        etInput2AddContact.background =
                            ContextCompat.getDrawable(
                                requireActivity(),
                                R.drawable.et_drawable_red
                            )
                        lifecycleScope.launch {
                            delay(1500)
                            etInput1AddContact.background =
                                ContextCompat.getDrawable(
                                    requireActivity(),
                                    R.drawable.et_drawable
                                )
                            etInput2AddContact.background =
                                ContextCompat.getDrawable(
                                    requireActivity(),
                                    R.drawable.et_drawable
                                )
                        }
                    }
                }
            }
        }
    }
}