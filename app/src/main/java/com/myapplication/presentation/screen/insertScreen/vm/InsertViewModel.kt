package com.myapplication.presentation.screen.insertScreen.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.usecase.insertUseCase.useCase.InsertUseCase
import kotlinx.coroutines.launch

class InsertViewModel(private val insertUseCase: InsertUseCase) : ViewModel() {

    fun insert(contactEntity: ContactEntity) {
        viewModelScope.launch {
            insertUseCase(contactEntity)
        }
    }
}