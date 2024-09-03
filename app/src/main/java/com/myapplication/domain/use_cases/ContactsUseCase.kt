package com.myapplication.domain.use_cases

import com.myapplication.data.database.entity.ContactEntity
import com.myapplication.data.repository.ContactRepositoryImpl
import kotlinx.coroutines.flow.Flow

class ContactsUseCase(private val contactRepositoryImpl: ContactRepositoryImpl) {

    operator fun invoke(): Flow<List<ContactEntity>> {
        return contactRepositoryImpl.getAllContacts()
    }
}