package com.myapplication.domain.repository

import com.myapplication.data.local.entity.ContactEntity
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    suspend fun insert(contactItem: ContactEntity)

    suspend fun update(contactItem: ContactEntity)

    suspend fun delete(contactItem: ContactEntity)

    fun getAllContacts(): Flow<List<ContactEntity>>
}