package com.myapplication.domain.usecase.insertUseCase

import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.repository.ContactRepository

class InsertUseCaseImpl(private var contactRepository: ContactRepository) : InsertUseCase {

    override suspend operator fun invoke(contactEntity: ContactEntity) {
        contactRepository.insert(contactEntity)
    }
}