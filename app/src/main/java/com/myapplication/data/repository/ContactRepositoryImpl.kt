package com.myapplication.data.repository

import com.myapplication.data.local.database.ContactDatabase
import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow

class ContactRepositoryImpl(private val db: ContactDatabase) : ContactRepository {

    override suspend fun insert(contactItem: ContactEntity) =
        db.contactDao().insert(contactItem)

    override suspend fun update(contactItem: ContactEntity) =
        db.contactDao().update(contactItem)

    override suspend fun delete(contactItem: ContactEntity) =
        db.contactDao().delete(contactItem)

    override fun getAllContacts(): Flow<List<ContactEntity>> =
        db.contactDao().getAllContacts()
}