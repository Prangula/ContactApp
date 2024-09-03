package com.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.database.entity.ContactEntity
import com.myapplication.domain.use_cases.DeleteUseCase
import kotlinx.coroutines.launch

class DeleteViewModel(private val deleteUseCase: DeleteUseCase) : ViewModel() {

    fun delete(contactItem: ContactEntity) {
        viewModelScope.launch {
            deleteUseCase(contactItem)
        }
    }
}