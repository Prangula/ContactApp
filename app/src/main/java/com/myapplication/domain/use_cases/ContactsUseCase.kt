package com.myapplication.domain.use_cases

import com.myapplication.data.database.ContactItem
import com.myapplication.data.repository.ContactRepositoryImpl
import kotlinx.coroutines.flow.Flow

class ContactsUseCase(private val contactRepositoryImpl: ContactRepositoryImpl) {

    operator fun invoke(): Flow<List<ContactItem>> {
        return contactRepositoryImpl.getAllContacts()
    }
}