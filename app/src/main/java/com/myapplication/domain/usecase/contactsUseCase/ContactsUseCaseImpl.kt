package com.myapplication.domain.usecase.contactsUseCase

import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow

class ContactsUseCaseImpl(private val contactRepository: ContactRepository) : ContactsUseCase {

    override suspend operator fun invoke(): Flow<List<ContactDomain>> {
        return contactRepository.getAllContacts()
    }
}