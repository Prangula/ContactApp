package com.myapplication.presentation.screen.insertScreen.ui

import androidx.lifecycle.lifecycleScope
import com.myapplication.R
import com.myapplication.databinding.FragmentInsertBinding
import com.myapplication.presentation.base.BaseFragment
import com.myapplication.presentation.model.ContactUi
import com.myapplication.presentation.screen.insertScreen.vm.InsertViewModel
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class InsertFragment : BaseFragment<FragmentInsertBinding, InsertViewModel>(
    FragmentInsertBinding::inflate
) {
    override val viewModelClass: KClass<InsertViewModel> = InsertViewModel::class

    override fun onBind() {
        insert()
    }

    private fun insert() {
        binding.btnPlusAddContact.setOnClickListener {
            lifecycleScope.launch {
                with(binding) {
                    val name = etNameAddContact.text.toString()
                    val number = etNumberAddContact.text.toString()
                    if (name.isNotEmpty() && number.isNotEmpty()) {
                        val item = ContactUi(name, number)
                        viewModel.insert(item)
                        viewModel.backNavigation()
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