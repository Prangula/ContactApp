package com.myapplication.presentation.screen.insertScreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.myapplication.R
import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.databinding.FragmentInsertBinding
import com.myapplication.presentation.screen.insertScreen.vm.InsertViewModel
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
                        val action = InsertFragmentDirections.actionAddFragmentToHomeFragment()
                        findNavController().navigate(action)
                    } else {
                        viewModel.insertError(
                            etInput1AddContact,
                            etInput2AddContact,
                            R.drawable.et_drawable_red,
                            R.drawable.et_drawable,
                            requireActivity()
                        )
                    }
                }
            }
        }
    }
}