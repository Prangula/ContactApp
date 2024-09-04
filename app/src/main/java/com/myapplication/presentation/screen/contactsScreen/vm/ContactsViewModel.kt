package com.myapplication.presentation.screen.contactsScreen.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.usecase.contactsUseCase.useCase.ContactsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ContactsViewModel(private val contactsUseCase: ContactsUseCase) : ViewModel() {

    private val _contacts = MutableStateFlow<List<ContactEntity>>(emptyList())
    val contacts = _contacts.asStateFlow()

    init {
        getAllContacts()
    }

    private fun getAllContacts() {
        viewModelScope.launch {
            contactsUseCase().collect { item ->
                _contacts.value = item
            }
        }
    }
}