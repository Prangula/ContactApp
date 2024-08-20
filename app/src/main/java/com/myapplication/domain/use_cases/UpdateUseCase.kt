package com.myapplication.domain.use_cases

import com.myapplication.data.database.ContactItem
import com.myapplication.data.repository.ContactRepositoryImpl

class UpdateUseCase(private val contactRepositoryImpl: ContactRepositoryImpl) {

    suspend operator fun invoke(contactItem: ContactItem) {
        contactRepositoryImpl.update(contactItem)
    }
}