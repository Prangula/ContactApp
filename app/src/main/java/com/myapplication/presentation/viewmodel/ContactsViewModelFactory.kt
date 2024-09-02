package com.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myapplication.domain.use_cases.ContactsUseCase

class ContactsViewModelFactory(private val contactsUseCase: ContactsUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return ContactsViewModel(contactsUseCase) as T
    }
}