package com.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.database.ContactItem
import com.myapplication.domain.use_cases.ContactsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ContactsViewModel(private val contactsUseCase: ContactsUseCase) : ViewModel() {

    private val _contacts = MutableStateFlow<List<ContactItem>>(emptyList())
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