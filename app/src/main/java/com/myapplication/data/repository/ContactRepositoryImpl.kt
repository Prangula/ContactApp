package com.myapplication.data.repository

import com.myapplication.data.local.database.ContactDatabase
import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.data.local.localMapper.ContactDomainMapper
import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ContactRepositoryImpl(
    private val db: ContactDatabase,
    private val contactDomainMapper: ContactDomainMapper
) : ContactRepository {

    override suspend fun insert(contactDomain: ContactDomain) {
        val contactEntity =
            contactDomainMapper.reverse(contactDomain)
        db.contactDao().insert(contactEntity)
    }

    override suspend fun update(contactDomain: ContactDomain) {
        val contactEntity =
            contactDomainMapper.reverse(contactDomain)
        db.contactDao().update(contactEntity)
    }


    override suspend fun delete(contactDomain: ContactDomain) {
        val contactEntity =
            contactDomainMapper.reverse(contactDomain)
        db.contactDao().delete(contactEntity)
    }

    override fun getAllContacts(): Flow<List<ContactDomain>> =
        db.contactDao().getAllContacts().map { items ->
            items.map { item ->
                contactDomainMapper(item)
            }
        }
}