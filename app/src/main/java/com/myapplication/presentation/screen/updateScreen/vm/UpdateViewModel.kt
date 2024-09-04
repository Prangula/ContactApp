package com.myapplication.presentation.screen.updateScreen.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.usecase.updateUseCase.useCase.UpdateUseCase
import kotlinx.coroutines.launch

class UpdateViewModel(private val updateUseCase: UpdateUseCase) : ViewModel() {

    fun update(contactItem: ContactEntity) {
        viewModelScope.launch {
            updateUseCase(contactItem)
        }
    }
}