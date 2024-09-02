package com.myapplication.data.repository

import com.myapplication.data.database.ContactDatabase
import com.myapplication.data.database.ContactItem
import kotlinx.coroutines.flow.Flow

class ContactRepositoryImpl(private val db: ContactDatabase) {

    suspend fun insert(contactItem: ContactItem) =
        db.contactDao().insert(contactItem)

    suspend fun update(contactItem: ContactItem) =
        db.contactDao().update(contactItem)

    suspend fun delete(contactItem: ContactItem) {
        db.contactDao().delete(contactItem)
    }

    fun getAllContacts() =
        db.contactDao().getAllContacts()
}

