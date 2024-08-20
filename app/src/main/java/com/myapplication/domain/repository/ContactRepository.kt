package com.myapplication.domain.repository

import com.myapplication.data.database.ContactItem
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    suspend fun insert(contactItem: ContactItem)

    suspend fun update(contactItem: ContactItem)

    suspend fun getAllContacts(): Flow<List<ContactItem>>

}