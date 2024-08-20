package com.myapplication.data.repository

import com.myapplication.data.database.ContactDatabase
import com.myapplication.data.database.ContactItem
import com.myapplication.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow

class ContactRepositoryImpl(private val db: ContactDatabase) : ContactRepository {
    override suspend fun insert(contactItem: ContactItem) {
        return db.contactDao().insert(contactItem)
    }

    override suspend fun update(contactItem: ContactItem) {
        return db.contactDao().update(contactItem)
    }

    override suspend fun getAllContacts(): Flow<List<ContactItem>> {
        return db.contactDao().getAllContacts()
    }

}

