package com.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myapplication.domain.use_cases.ContactsUseCase
import com.myapplication.domain.use_cases.InsertUseCase

class InsertViewModelFactory(private val insertUseCase: InsertUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return InsertViewModel(insertUseCase) as T
    }
}