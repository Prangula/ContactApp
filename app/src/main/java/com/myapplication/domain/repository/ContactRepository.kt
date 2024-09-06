package com.myapplication.domain.repository

import com.myapplication.domain.model.ContactDomain
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    suspend fun insert(contactDomain: ContactDomain)

    suspend fun update(contactDomain: ContactDomain)

    suspend fun delete(contactDomain: ContactDomain)

    fun getAllContacts(): Flow<List<ContactDomain>>
}