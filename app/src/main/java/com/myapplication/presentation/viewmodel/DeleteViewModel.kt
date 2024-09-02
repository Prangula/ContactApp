package com.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.database.ContactItem
import com.myapplication.domain.use_cases.DeleteUseCase
import com.myapplication.domain.use_cases.InsertUseCase
import kotlinx.coroutines.launch

class DeleteViewModel(private val deleteUseCase: DeleteUseCase) : ViewModel() {

    fun delete(contactItem: ContactItem) {
        viewModelScope.launch {
            deleteUseCase(contactItem)
        }
    }
}