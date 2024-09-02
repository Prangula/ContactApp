package com.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.database.ContactItem
import com.myapplication.domain.use_cases.UpdateUseCase
import kotlinx.coroutines.launch

class UpdateViewModel(private val updateUseCase: UpdateUseCase) : ViewModel() {

    fun update(contactItem: ContactItem) {
        viewModelScope.launch {
            updateUseCase(contactItem)
        }
    }
}