package com.myapplication.data.repository

import com.myapplication.data.local.database.ContactDatabase
import com.myapplication.data.local.mapper.ContactEntityToDomainMapper
import com.myapplication.data.local.mapper.ContactDomainToEntityMapper
import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ContactRepositoryImpl(
    private val db: ContactDatabase,
    private val contactDomainToEntityMapper: ContactDomainToEntityMapper,
    private val contactEntityToDomainMapper: ContactEntityToDomainMapper
) : ContactRepository {

    override suspend fun insert(contactDomain: ContactDomain) {
        db.contactDao().insert(contactDomainToEntityMapper.mapModel(contactDomain))
    }

    override suspend fun update(contactDomain: ContactDomain) {
        db.contactDao().update(contactDomainToEntityMapper.mapModel(contactDomain))
    }

    override suspend fun delete(contactDomain: ContactDomain) {
        db.contactDao().delete(contactDomainToEntityMapper.mapModel(contactDomain))
    }

    override fun getAllContacts(): Flow<List<ContactDomain>> {
        return db.contactDao().getAllContacts().map { contactsList ->
            contactEntityToDomainMapper.mapToList(contactsList)
        }
    }
}