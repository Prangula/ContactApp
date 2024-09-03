package com.myapplication.data.repository

import com.myapplication.data.database.database.ContactDatabase
import com.myapplication.data.database.entity.ContactEntity

class ContactRepositoryImpl(private val db: ContactDatabase) {

    suspend fun insert(contactItem: ContactEntity) =
        db.contactDao().insert(contactItem)

    suspend fun update(contactItem: ContactEntity) =
        db.contactDao().update(contactItem)

    suspend fun delete(contactItem: ContactEntity) {
        db.contactDao().delete(contactItem)
    }

    fun getAllContacts() =
        db.contactDao().getAllContacts()
}

