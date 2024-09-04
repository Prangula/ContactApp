package com.myapplication.domain.usecase.contactsUseCase.useCaseImpl

import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.repository.ContactRepository
import com.myapplication.domain.usecase.contactsUseCase.useCase.ContactsUseCase
import kotlinx.coroutines.flow.Flow

class ContactsUseCaseImpl(private val contactRepository: ContactRepository) : ContactsUseCase {

    override suspend operator fun invoke(): Flow<List<ContactEntity>> {
        return contactRepository.getAllContacts()
    }
}