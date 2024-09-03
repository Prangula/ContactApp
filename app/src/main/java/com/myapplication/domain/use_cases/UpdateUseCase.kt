package com.myapplication.domain.use_cases

import com.myapplication.data.database.entity.ContactEntity
import com.myapplication.data.repository.ContactRepositoryImpl

class UpdateUseCase(private val contactRepositoryImpl: ContactRepositoryImpl) {

    suspend operator fun invoke(contactItem: ContactEntity) {
        contactRepositoryImpl.update(contactItem)
    }
}