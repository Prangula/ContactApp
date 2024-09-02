package com.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.database.ContactItem
import com.myapplication.domain.use_cases.InsertUseCase
import kotlinx.coroutines.launch

class InsertViewModel(private val insertUseCase: InsertUseCase) : ViewModel() {

    fun insert(contactItem: ContactItem) {
        viewModelScope.launch {
            insertUseCase(contactItem)
        }
    }
}