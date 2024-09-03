package com.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.database.entity.ContactEntity
import com.myapplication.domain.use_cases.UpdateUseCase
import kotlinx.coroutines.launch

class UpdateViewModel(private val updateUseCase: UpdateUseCase) : ViewModel() {

    fun update(contactItem: ContactEntity) {
        viewModelScope.launch {
            updateUseCase(contactItem)
        }
    }
}