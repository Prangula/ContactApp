package com.myapplication.domain.use_cases

import com.myapplication.data.database.entity.ContactEntity
import com.myapplication.data.repository.ContactRepositoryImpl

class InsertUseCase(private var contactRepositoryImpl: ContactRepositoryImpl) {

    suspend operator fun invoke(contactItem: ContactEntity) {
        contactRepositoryImpl.insert(contactItem)
    }
}