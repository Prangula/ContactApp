package com.myapplication.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.myapplication.R
import com.myapplication.data.database.ContactDatabase
import com.myapplication.data.database.ContactItem
import com.myapplication.data.repository.ContactRepositoryImpl
import com.myapplication.databinding.FragmentAddBinding
import com.myapplication.domain.use_cases.InsertUseCase
import com.myapplication.presentation.viewmodel.InsertViewModel
import com.myapplication.presentation.viewmodel.InsertViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AddFragment : Fragment(R.layout.fragment_add) {

    private lateinit var binding: FragmentAddBinding
    private lateinit var viewModel: InsertViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = ContactDatabase(requireActivity())
        val repositoryImpl = ContactRepositoryImpl(database)
        val insertUseCase = InsertUseCase(repositoryImpl)
        val factory = InsertViewModelFactory(insertUseCase)
        viewModel = ViewModelProvider(requireActivity(), factory).get(InsertViewModel::class.java)

        insert()
    }

    private fun insert() {
        binding.btnPlusAddContact.setOnClickListener {
            lifecycleScope.launch {
                val name = binding.etNameAddContact.text.toString()
                val number = binding.etNumberAddContact.text.toString()
                if (name.isNotEmpty() && number.isNotEmpty()) {
                    val item = ContactItem(name, number)
                    viewModel.insert(item)
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.navHostFragment, HomeFragment())
                        .commit()
                } else {
                    binding.etInput1AddContact.background =
                        ContextCompat.getDrawable(
                            requireActivity(),
                            R.drawable.et_drawable_red
                        )
                    binding.etInput2AddContact.background =
                        ContextCompat.getDrawable(
                            requireActivity(),
                            R.drawable.et_drawable_red
                        )
                    lifecycleScope.launch {
                        delay(1500)
                        binding.etInput1AddContact.background =
                            ContextCompat.getDrawable(
                                requireActivity(),
                                R.drawable.et_drawable
                            )
                        binding.etInput2AddContact.background =
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