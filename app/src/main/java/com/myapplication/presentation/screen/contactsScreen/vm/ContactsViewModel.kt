package com.myapplication.presentation.screen.contactsScreen.vm

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.myapplication.presentation.mapper.ContactDomainToUiMapper
import com.myapplication.domain.usecase.contactsUseCase.ContactsUseCase
import com.myapplication.domain.usecase.deleteUseCase.DeleteUseCase
import com.myapplication.presentation.base.BaseViewModel
import com.myapplication.presentation.mapper.ContactUiToDomainMapper
import com.myapplication.presentation.model.ContactUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ContactsViewModel(
    private val contactsUseCase: ContactsUseCase,
    private val deleteUseCase: DeleteUseCase,
    private val contactDomainToUiMapper: ContactDomainToUiMapper,
    private val contactUiToDomainMapper: ContactUiToDomainMapper,
) : BaseViewModel(
    mapper = contactUiToDomainMapper::mapModel,
    useCase = { deleteUseCase(it) }
) {

    private val _contacts = MutableStateFlow<List<ContactUi>>(emptyList())
    val contacts = _contacts.asStateFlow()
    val emptyContacts: Flow<Boolean> = _contacts.map { it.isEmpty() }

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

    fun delete(contactUi: ContactUi) {
        baseFun(contactUi)
    }

    override fun navController(navController: NavController, action: NavDirections) {
        navController.navigate(action)
    }

    override fun popStackBack(navController: NavController, fragmentId: Int, boolean: Boolean) {
        navController.popBackStack(fragmentId, boolean)
    }
}