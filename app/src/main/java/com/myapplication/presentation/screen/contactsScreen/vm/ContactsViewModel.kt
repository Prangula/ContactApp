package com.myapplication.presentation.screen.contactsScreen.vm

import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.presentation.mapper.ContactDomainToUiMapper
import com.myapplication.domain.usecase.contactsUseCase.ContactsUseCase
import com.myapplication.domain.usecase.deleteUseCase.DeleteUseCase
import com.myapplication.presentation.mapper.ContactUiToDomainMapper
import com.myapplication.presentation.model.ContactUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ContactsViewModel(
    private val contactsUseCase: ContactsUseCase,
    private val deleteUseCase: DeleteUseCase,
    private val contactDomainToUiMapper: ContactDomainToUiMapper,
    private val contactUiToDomainMapper: ContactUiToDomainMapper
) : ViewModel() {

    private val _contacts = MutableStateFlow<List<ContactUi>>(emptyList())
    val contacts = _contacts.asStateFlow()

    init {
        getAllContacts()
    }

    private fun getAllContacts() {
        viewModelScope.launch {
            contactsUseCase().collect { contactsList ->
                _contacts.value = contactDomainToUiMapper.mapToList(contactsList)
            }
        }
    }

    fun rvVisibility(rv: RecyclerView, tv: TextView) {
        if (_contacts.value.isNotEmpty()) {
            rv.visibility = View.VISIBLE
            tv.visibility = View.GONE
        } else {
            rv.visibility = View.GONE
            tv.visibility = View.VISIBLE
        }
    }

    fun delete(contactUi: ContactUi) {
        viewModelScope.launch {
            val item = contactUiToDomainMapper.mapModel(contactUi)
            deleteUseCase(item)
        }
    }
}