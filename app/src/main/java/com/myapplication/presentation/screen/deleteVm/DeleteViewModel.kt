package com.myapplication.presentation.screen.deleteVm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.usecase.deleteUseCase.useCase.DeleteUseCase
import kotlinx.coroutines.launch

class DeleteViewModel(private val deleteUseCase: DeleteUseCase) : ViewModel() {

    fun delete(contactItem: ContactEntity) {
        viewModelScope.launch {
            deleteUseCase(contactItem)
        }
    }
}